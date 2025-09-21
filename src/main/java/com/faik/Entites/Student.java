package com.faik.Entites;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // otomatikmen kendi kendine artmasına denir
	private Integer id;
	
	@Column(name = "first_name"  )
	private String firstName;
	
	@Column(name = "last_name" )
	private String lastName;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name="birth_of_day", nullable = true)
	private String birthofDay;
}
