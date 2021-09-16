package com.etiya.ReCapProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.ReCapProject.business.abstracts.BrandService;
import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.core.utilities.results.Result;
import com.etiya.ReCapProject.entities.concretes.Brand;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {
	private BrandService brandService;

	@Autowired
	public BrandsController(BrandService brandService) {
		super();
		this.brandService = brandService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Brand>> getAll() {
		return this.brandService.getAll();
	}
	
	@GetMapping("/getbyid")
	public DataResult<Brand> getById(int brandId) {
		return this.brandService.getById(brandId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Brand brand) {
		return this.brandService.add(brand);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Brand brand) {
		return this.brandService.update(brand);
	}
	
	@PutMapping("/delete")
	public Result delete(@RequestBody Brand brand) {
		return this.brandService.delete(brand);
	}
	
	
	
}
