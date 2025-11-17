package com.demo.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "car")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 對應 MySQL INT AI
	private Integer id;

	@Column(length = 50)
	private String brand;

	@Column(name = "car_model", length = 50)
	private String carModel;

	@Column(name = "plate_number", length = 20)
	private String plateNumber;

	// 先當成一般欄位，之後再改成 @ManyToOne Branch
	@Column(name = "branch_id")
	private Integer branchId;

	@Column(name = "price_per_day", precision = 10, scale = 2)
	private BigDecimal pricePerDay;

	@Column(name = "price_per_km", precision = 10, scale = 2)
	private BigDecimal pricePerKm;

	// 目前 DB 是 ENUM('可租','維修中','租出中'...)，先用 String 接
	@Column(name = "status")
	private String status;
}
