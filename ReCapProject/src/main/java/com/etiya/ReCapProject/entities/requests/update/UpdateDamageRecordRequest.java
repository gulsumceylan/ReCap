package com.etiya.ReCapProject.entities.requests.update;

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
	
	private int id;
	@NotNull
	private String damageInformation;
	
	private int carId;
}
