package com.hibernate.entity;

import java.time.LocalDate;
import java.util.UUID;

import com.hibernate.enums.Gender;
import com.hibernate.enums.PetType;
import jakarta.persistence.*;
import lombok.Data;

//@IdClass(PrimaryKey.class)
@Data
@Entity
@Table(name = "owner_tables")
public class Owner {

//	@Id
//	private int id;
//
//	@Id
//	@Column(name = "Pet_Id",nullable = false)
//	private int petId;

	@EmbeddedId
	private PrimaryKey primaryKey;

	@Column(name = "First_Name",nullable = false)
	private String firstName;
	@Column(name = "Last_Name",nullable = false)
	private String lastName;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Column(nullable = false)
	private String city;
	@Column(nullable = false)
	private String state;
	@Column(name = "Mobile_Number",nullable = false,unique = true,length = 10)
	private String mobileNumber;
	@Column(name = "Email_Id",nullable = false,unique = true)
	private String emailId;
	@Column(name = "pet_name",nullable = false)
	private String petName;
	@Column(name = "Pet_DOB",nullable = false)
	private LocalDate petBirthDate;
	@Column(name = "Pet_Gender", nullable = false)
	@Enumerated(EnumType.STRING)
	private Gender petGender;
	@Column(name = "Pet_Type", nullable = false)
	@Enumerated(EnumType.STRING)
	private PetType petType;

}