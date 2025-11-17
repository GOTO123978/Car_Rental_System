package com.demo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "employee")
@EntityListeners(AuditingEntityListener.class)
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "employee_id")
	private String employeeId;

	private String password;

	private String name;

	private String phone;

	@Column(name = "identity_card_num")
	private String identityCardNum;

	private LocalDate birthday;

	private String gender;

	private String email;

	@Column(name = "register_date")
	@CreatedDate
	private LocalDateTime registerDate;
}
