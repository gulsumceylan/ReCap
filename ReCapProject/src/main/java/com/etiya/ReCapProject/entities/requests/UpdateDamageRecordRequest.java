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
public class UpdateDamageRecordRequest {
	@NotNull
	private int id;
	
	private String damageInformation;
	
	private int carId;
}
