package com.etiya.ReCapProject.api.controllers;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.etiya.ReCapProject.business.abstracts.CarImageService;
import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.core.utilities.results.Result;
import com.etiya.ReCapProject.entities.dtos.CarImageDetailDto;
import com.etiya.ReCapProject.entities.requests.carImage.CreateCarImageRequest;
import com.etiya.ReCapProject.entities.requests.carImage.DeleteCarImageRequest;
import com.etiya.ReCapProject.entities.requests.carImage.UpdateCarImageRequest;

@RestController
@RequestMapping("/api/carimages")
public class CarImagesController {
	
	private CarImageService carImageService;

	@Autowired
	public CarImagesController(CarImageService carImageService) {
		super();
		this.carImageService = carImageService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestParam("carId") int carId, MultipartFile file) throws IOException {
		
		CreateCarImageRequest createCarImageRequest = new CreateCarImageRequest();
		createCarImageRequest.setCarId(carId);
		createCarImageRequest.setFile(file);
		return this.carImageService.add(createCarImageRequest);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CarImageDetailDto>> getAll(){
		
		return this.carImageService.getAll();
	}
	
	@GetMapping("/getbyid")
	public DataResult<CarImageDetailDto> getById(int id){
		return this.carImageService.getById(id);
	}
	
	@PostMapping("/update")
    public Result update(@RequestParam("carImageId") int id, MultipartFile file) throws IOException {
        UpdateCarImageRequest updateCarImageRequest = new UpdateCarImageRequest();
        updateCarImageRequest.setCarImageId(id);
        updateCarImageRequest.setFile(file);
        return this.carImageService.update(updateCarImageRequest);
    }
	
	@PutMapping("/delete")
	public Result delete(@Valid @RequestBody DeleteCarImageRequest deleteCarImageRequest) {
		return this.carImageService.delete(deleteCarImageRequest);
	}
	
	@GetMapping("/getbycarid")
	public DataResult<List<CarImageDetailDto>> getByCarId(int carId){
		return this.carImageService.getByCarId(carId);
	}
	

}
