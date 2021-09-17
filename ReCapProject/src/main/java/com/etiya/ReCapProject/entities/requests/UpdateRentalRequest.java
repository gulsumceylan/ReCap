package com.etiya.ReCapProject.entities.requests;

import java.util.Date;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRentalRequest {
	@NotNull(message = "Boş olamaz")
	private int id;
	
	private String carName;
	
	private int carId;

	@NotNull(message = "Boş olamaz")
	private Date rentDate;

	private Date returnDate;
}
