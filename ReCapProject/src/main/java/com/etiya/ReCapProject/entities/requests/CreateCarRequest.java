package com.etiya.ReCapProject.entities.requests;

import javax.validation.constraints.Min;
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
public class CreateCarRequest {
	@NotBlank(message = "Boş olamaz")
	@NotNull
	private String carName;
	
	@NotNull(message = "Boş olamaz")
	private int BrandId;
	
	@NotNull(message = "Boş olamaz")
	private int colorId;
	
	@NotNull(message = "Boş olamaz")
	private int modelYear;
	
	@NotNull(message = "Boş olamaz")
	@Min(0)
	private double dailyPrice;
	
	@NotBlank(message = "Boş olamaz")
	@NotNull
	private String description;
	
	
}
