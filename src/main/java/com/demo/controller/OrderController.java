package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.demo.model.Order;
import com.demo.repository.OrderRepository;

@Controller
public class OrderController {

	@Autowired
	OrderRepository orderRepo;

	@GetMapping("/my-orders")
	public String myOrders(Model model) {

		// ★★★ 未來 JWT 整合點：改為 orderRepo.findByUserId(...) ★★★
		List<Order> orders = orderRepo.findAll();

		model.addAttribute("orders", orders);

		return "my-orders";
	}

	@GetMapping("/order/cancel/{id}")
	public String cancelOrder(@PathVariable Integer id) {

		// ★★★ 未來 JWT 整合點：檢查訂單權限 ★★★
		Order order = orderRepo.findById(id).orElse(null);

		if (order != null) {
			order.setStatus("已取消");
			orderRepo.save(order);
		}

		return "redirect:/my-orders";
	}
}