package com.etiya.ReCapProject.entities.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBrandRequest {
	@NotNull(message = "Boş olamaz")
	private int brandId;
	
	@NotBlank(message = "Boş olamaz")
	@NotNull
	private String brandName;
}
