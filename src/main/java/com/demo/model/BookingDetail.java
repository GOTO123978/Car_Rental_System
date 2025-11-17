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
@Table(name = "booking_detail")
public class BookingDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "booking_id")
	private String bookingId;

	@Column(name = "detail_id")
	private Integer detailId;

	@Column(name = "items_id")
	private String itemsId;

	@Column
	private Integer quantity;
}
