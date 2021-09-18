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
public class UpdateCarImageRequest {
	@NotNull(message = "Boş olamaz")
	private int id;
	
	@NotBlank
	@NotNull(message = "Boş olamaz")
	private String imagePath;
	
	@NotNull(message = "Boş olamaz")
	private int carId;

}
