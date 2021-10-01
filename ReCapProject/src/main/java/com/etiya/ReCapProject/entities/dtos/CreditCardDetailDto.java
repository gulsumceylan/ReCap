package com.etiya.ReCapProject.entities.dtos;

import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardDetailDto {
	@NotNull
	private String name;
	
	@NotNull
	@Size(min=16,max=16)
	private String cardNumber;

	@NotNull
	private String expiryDate;

	@NotNull
	@Size(min=3,max=3)
	private String cvv;
}
