package com.etiya.ReCapProject.entities.requests;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarImageRequest {

	@NotNull(message = "Boş olamaz")
	private int carId;
	
	private String imagePath;
	
	@JsonIgnore
	private MultipartFile file;

}