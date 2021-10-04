package com.etiya.ReCapProject.entities.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdditionalServiceDetailDto {

	private int id;

	private String name;

	private String description;

	private double dailyPrice;

	private List<RentalDetailDto> rentalDetailDtos;
}
