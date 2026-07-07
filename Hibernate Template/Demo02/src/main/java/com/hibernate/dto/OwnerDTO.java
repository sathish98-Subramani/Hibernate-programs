package com.hibernate.dto;

import com.hibernate.enums.Gender;
import com.hibernate.enums.PetType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class OwnerDTO {
	private int id;
	private String firstName;
	private String lastName;
	private Gender gender;
	private String city;
	private String state;
	private String mobileNumber;
	private String emailId;
	private int petId;
	private String petName;
	private LocalDate petBirthDate;
	private Gender petGender;
	private PetType petType;


}