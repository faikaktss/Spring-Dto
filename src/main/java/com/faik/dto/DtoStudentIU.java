package com.faik.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudentIU {
	
	@NotEmpty(message = "First_Name alanı boş bırakılamaz")
	@NotNull(message = "First_Name alanı null olamaz")
	private String firstName;
	
	@Size(min = 3,max = 10)
	private String lastName; 
	
	private String birthofDay;

	@Email(message = "Email alanı boş bırakılamaz")
	private String email;
}