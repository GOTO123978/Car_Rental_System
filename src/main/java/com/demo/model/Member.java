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
@Table(name = "member")
@EntityListeners(AuditingEntityListener.class)
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "member_id")
	private String memberId;

	private String name;

	private String phone;

	@Column(name = "id_number")
	private String idNumber;

	private LocalDate birthday;

	private String gender;

	private String email;

	private String address;

	private String password;

	@Column(name = "register_date")
	@CreatedDate
	private LocalDateTime registerDate;
}
