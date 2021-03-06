package com.etiya.ReCapProject.entities.requests.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
	
	@JsonIgnore
	private int id;
	
	@NotBlank(message="Boş olamaz")
	@NotNull
	@Email
	private String Email;
	
	@NotBlank(message="Boş olamaz")
	@NotNull
	@Size(min=6)
	private String password;
	
	
	
	
}
