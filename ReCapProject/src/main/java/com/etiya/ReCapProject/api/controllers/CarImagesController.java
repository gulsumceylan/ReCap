package com.etiya.ReCapProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.ReCapProject.business.abstracts.CarImageService;
import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.core.utilities.results.Result;
import com.etiya.ReCapProject.entities.concretes.CarImage;
import com.etiya.ReCapProject.entities.requests.CreateCarImageRequest;
import com.etiya.ReCapProject.entities.requests.DeleteCarImageRequest;
import com.etiya.ReCapProject.entities.requests.UpdateCarImageRequest;


@RestController
@RequestMapping("/api/carImages")
public class CarImagesController {
	private CarImageService carImageService;
	
	@Autowired
	public CarImagesController(CarImageService carImageService) {
		super();
		this.carImageService = carImageService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CreateCarImageRequest createCarImageRequest) {
		
	 return this.carImageService.add(createCarImageRequest);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CarImage>> getAll(){
		
		return this.carImageService.getAll();
	}
	
	@GetMapping("/getbyid")
	public DataResult<CarImage> getById( int carImageId){
		return this.carImageService.getById(carImageId);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody UpdateCarImageRequest updateCarImageRequest) {
		return this.carImageService.update(updateCarImageRequest);
	}
	
	@PutMapping("/delete")
	public Result delete(@RequestBody DeleteCarImageRequest deleteCarImageRequest) {
		return this.carImageService.delete(deleteCarImageRequest);
	}
	
	@GetMapping("/getbycarid")
	public DataResult<List<CarImage>> getByCarId( int carId){
		return this.carImageService.getByCarId(carId);
	}
	
}