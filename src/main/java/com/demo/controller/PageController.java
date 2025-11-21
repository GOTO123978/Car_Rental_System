package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.demo.Service.BranchService;
import com.demo.model.Branch;

@Controller
public class PageController {

	@Autowired
	BranchService branchService;

	// 首頁
	@GetMapping("/")
	public String home() {
		return "index";
	}

	// 預約租車首頁 (Step 1) - 需載入分店資料供下拉選單使用
	@GetMapping("/reserve")
	public String showReservePage(Model model) {
		List<Branch> branches = branchService.findAll();
		model.addAttribute("branches", branches);
		return "reserve"; // 對應 templates/reserve.html
	}
}