package com.etiya.ReCapProject.entities.requests;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

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
	
	private int carId;
	
	private MultipartFile file;

}
