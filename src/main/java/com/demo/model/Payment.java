package com.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "payment")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "payment_id", length = 45)
	private String paymentId;

	@Column(name = "detail_id")
	private Integer detailId;

	@Column(name = "subprice")
	private Integer subprice;

	@Column(length = 45)
	private String method;

	@Column(length = 45)
	private String status;
}