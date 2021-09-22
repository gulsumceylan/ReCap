package com.etiya.ReCapProject.entities.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserForRegisterDto {
	@NotBlank(message = "Boş olamaz")
	@NotNull
	private String firstName;
	
	@NotBlank(message = "Boş olamaz")
	@NotNull
	private String lastName;
	
	@NotBlank(message = "Boş olamaz")
	@NotNull
	@Email
	private String email;

	@Size(min = 6, max = 20)
	@NotBlank(message = "Boş olamaz")
	@NotNull
	private String password;
}
