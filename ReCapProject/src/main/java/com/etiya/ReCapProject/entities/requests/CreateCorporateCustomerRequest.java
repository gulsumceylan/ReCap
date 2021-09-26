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
public class CreateCorporateCustomerRequest {	
	
	@NotBlank(message = "Boş olamaz")
	@NotNull
	@Size(min=10,max=10)
	private String taxNumber;
	
	@NotBlank(message = "Boş olamaz")
	@NotNull
	private String companyName;

	@NotBlank(message = "Boş olamaz")
	@NotNull
	@Email
	private String email;
	
	@Size(min=6, max=20)
	@NotBlank(message = "Boş olamaz")
	@NotNull
	private String password;
	
	
}
