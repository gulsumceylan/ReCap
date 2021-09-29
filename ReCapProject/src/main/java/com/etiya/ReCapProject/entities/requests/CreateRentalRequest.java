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
public class CreateRentalRequest {
	@NotNull(message = "Boş olamaz")
	private int customerId;

	@NotNull(message = "Boş olamaz")
	private int carId;

	@NotNull(message = "Boş olamaz")
	private Date rentDate;
	
	private Date returnDate;

	private String returnLocation;
}
