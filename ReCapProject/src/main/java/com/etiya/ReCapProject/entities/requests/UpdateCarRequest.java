package com.etiya.ReCapProject.entities.requests;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {
	@NotNull(message = "Boş olamaz")
	private int carId;
	
	private String carName;
	
	private int brandId;
	
	private int colorId;

	private int modelYear;

	private double dailyPrice;

	private String description;
	
	private int minFindexScore;

	private String city;
	
	private int km; 
	
}
