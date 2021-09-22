package com.etiya.ReCapProject.entities.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserProfileDto {
	
	private int id;

	@Email
	private String email;

	@Size(min = 6, max = 20)
	private String password;
}
