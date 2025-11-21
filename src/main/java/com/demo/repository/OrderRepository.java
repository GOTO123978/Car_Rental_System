package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	// ★★★ 未來 JWT 整合預留 ★★★
	// 未來您需要查詢「特定使用者的訂單」，屆時請取消註解並補上 User 關聯：
	// List<Order> findByUserId(Integer userId);
}