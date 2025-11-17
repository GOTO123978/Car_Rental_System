package com.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "booking")
public class booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "booking_id", length = 45)
	private String bookingId;

	@Column(name = "member_id", length = 45)
	private String memberId;

	@Column(name = "car_id", length = 45)
	private String carId;

	@Column(name = "booking_date")
	private LocalDateTime bookingDate;

	@Column(name = "scheduled_pickup_time")
	private LocalDateTime scheduledPickupTime;

	@Column(name = "scheduled_return_time")
	private LocalDateTime scheduledReturnTime;

	@Column(name = "actual_pickup_time")
	private LocalDateTime actualPickupTime;

	@Column(name = "actual_return_time")
	private LocalDateTime actualReturnTime;

	@Column(name = "pickup_station", length = 45)
	private String pickupStation;

	@Column(name = "return_station", length = 45)
	private String returnStation;

	@Column(name = "status", length = 45)
	private String status;
}
