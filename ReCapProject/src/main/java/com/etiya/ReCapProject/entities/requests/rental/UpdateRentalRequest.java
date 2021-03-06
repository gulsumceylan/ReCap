package com.etiya.ReCapProject.entities.requests.rental;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.etiya.ReCapProject.entities.dtos.AdditionalServiceForRentalDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRentalRequest {
	
	@NotNull
	private int rentalId;
	
	private int carId;
	
	@NotNull
	private Date rentDate;

	private Date returnDate;

	@NotNull
	private String returnLocation;
	
	private List<AdditionalServiceForRentalDto> additionalServiceDtos;
	
}
