package com.etiya.ReCapProject.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import com.etiya.ReCapProject.entities.concretes.Brand;
import com.etiya.ReCapProject.entities.dtos.BrandDetailDto;

public interface BrandDao extends JpaRepository<Brand, Integer>{
	
	boolean existsByBrandName(String brandName);
	
	
	BrandDetailDto getByBrandId(int brandId);

}
