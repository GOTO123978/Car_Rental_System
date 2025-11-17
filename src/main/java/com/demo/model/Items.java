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
@Table(name = "items")
public class Items {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "items_id", length = 45)
	private String itemsId;

	@Column(name = "items_name", length = 45)
	private String itemsName;

	@Column(name = "price_per_day")
	private Integer pricePerDay;

	@Column(name = "category", length = 45)
	private String category;
}
