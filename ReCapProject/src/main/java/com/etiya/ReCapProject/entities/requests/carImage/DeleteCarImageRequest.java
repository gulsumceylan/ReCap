package com.etiya.ReCapProject.entities.requests.carImage;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeleteCarImageRequest {
		
	@NotNull
	private int carImageId;

	
	
}
