package com.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CarType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "type_id", length = 45)
	private String typeId;

	@Column(length = 45)
	private String brand;

	@Column(length = 45)
	private String model;

	@Column(length = 255)
	private String image;

	@Column(name = "seat_count")
	private Integer seatCount;

	@Column(name = "price_per_day")
	private Integer pricePerDay;

}
