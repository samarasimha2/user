package com.akhm.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="USER_TL")
public class UserEntity {
	@Id
	@GeneratedValue
	@Column(name="USER_ID")
	private Integer userId;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="EMAIL_ID")
	private String emailId;
	@Column(name="PASSWORD")
	private String password;
	@Column(name="MOBILE_NUMBER")
	private String mobileNumber;
}
