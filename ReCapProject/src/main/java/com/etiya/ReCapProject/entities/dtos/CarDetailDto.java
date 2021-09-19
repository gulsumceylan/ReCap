package com.etiya.ReCapProject.entities.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDetailDto {
	private String carName;
	private String brandName;
	private String colorName;
	private double dailyPrice;
}
