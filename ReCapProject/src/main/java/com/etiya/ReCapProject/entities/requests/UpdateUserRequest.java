package com.etiya.ReCapProject.entities.requests;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {
	@NotNull(message = "Boş olamaz")
	private int id;
	
	@NotBlank(message = "Boş olamaz")
	@NotNull
	@Size(min=2, max=30)
	private String firstName;
	
	@Size(min=2, max=30)
	@NotBlank(message = "Boş olamaz")
	@NotNull
	private String lastName;
	
	@NotBlank(message = "Boş olamaz")
	@NotNull
	@Email
	private String email;
	
	@Size(min=6, max=20)
	@NotBlank(message = "Boş olamaz")
	@NotNull
	private String password;
}
