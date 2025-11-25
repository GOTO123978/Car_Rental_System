package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Service.DriverOrderService;
import com.demo.model.DriverOrder;
import com.demo.util.JwtUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor

public class DriverOrderController {

	private final DriverOrderService driverOrderService;

	// ⭐ 注入 JwtUtil
	@Autowired
	private JwtUtil jwtUtil;

	// 建立新訂單 (加入權限驗證)
	@PostMapping
	public ResponseEntity<?> createOrder(@RequestBody DriverOrder dorder,
			@RequestHeader(value = "Authorization", required = false) String authHeader) {

		// 1. 檢查 Token 是否存在
		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("請先登入會員");
		}

		// 2. 驗證 Token
		String token = authHeader.substring(7);
		if (!jwtUtil.validateToken(token)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("登入逾時，請重新登入");
		}

		// 3. 解析會員 ID (從 Token 取得 username/idNumber)
		// 注意：我們之前的 JwtUtil 是用 idNumber 生成 Token 的
		// 如果您希望這裡存 memberId，您可能需要去 MemberRepository 查一下，或者我們暫存 idNumber
		String userIdNumber = jwtUtil.getUsernameFromToken(token);

		// 這裡我們暫時將解析出來的 ID 存入 (實務上建議再查一次 DB 轉成 memberId)
		dorder.setMemberId(userIdNumber);

		try {
			DriverOrder saved = driverOrderService.createDorder(dorder);
			return ResponseEntity.status(HttpStatus.CREATED).body(saved);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("建立訂單失敗：" + e.getMessage());
		}
	}

	// 依電話查詢訂單
	@GetMapping("/phone/{phone}")
	public ResponseEntity<?> getOrdersByPhone(@PathVariable String phone) {
		List<DriverOrder> list = driverOrderService.findDorderByPhone(phone);
		if (list.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(list);
	}

	// 查詢所有訂單
	@GetMapping("/getall")
	public ResponseEntity<?> getAllOrders() {
		return ResponseEntity.ok(driverOrderService.findAll());
	}

	// 依 ID 查詢訂單
	@GetMapping("/{id}")
	public ResponseEntity<?> getOrderById(@PathVariable Long id) {
		DriverOrder order = driverOrderService.findById(id);
		if (order == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(order);
	}

	// 依 orderNo 查詢
	@GetMapping("/find/orderNo/{orderNo}")
	public ResponseEntity<?> getOrderByOrderNo(@PathVariable String orderNo) {
		DriverOrder order = driverOrderService.findByOrderNo(orderNo);

		if (order == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("查無此訂單：" + orderNo);
		}

		return ResponseEntity.ok(order);
	}
}
