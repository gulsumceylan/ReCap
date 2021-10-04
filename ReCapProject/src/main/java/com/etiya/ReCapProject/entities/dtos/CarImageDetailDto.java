package com.etiya.ReCapProject.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarImageDetailDto {
	private int id;

	private String imagePath;

	private LocalDate date;

	private String carName;
	
}
