package com.etiya.ReCapProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.ReCapProject.business.abstracts.ColorService;
import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.core.utilities.results.Result;
import com.etiya.ReCapProject.entities.concretes.Color;

@RestController
@RequestMapping("/api/colors")
public class ColorsController {

	private ColorService colorService;

	@Autowired
	public ColorsController(ColorService colorService) {
		super();
		this.colorService = colorService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Color>> getAll() {
		return this.colorService.getAll();
	}
	
	@GetMapping("/getbyid")
	public DataResult<Color> getById(int colorId) {
		return this.colorService.getById(colorId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Color color) {
		return this.colorService.add(color);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Color color) {
		return this.colorService.update(color);
	}
	
	@PutMapping("/delete")
	public Result delete(@RequestBody Color color) {
		return this.colorService.delete(color);
	}
}
