package com.etiya.ReCapProject.business.abstracts;

import java.util.List;

import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.core.utilities.results.Result;
import com.etiya.ReCapProject.entities.concretes.Brand;
import com.etiya.ReCapProject.entities.requests.CreateBrandRequest;
import com.etiya.ReCapProject.entities.requests.DeleteBrandRequest;
import com.etiya.ReCapProject.entities.requests.UpdateBrandRequest;

public interface BrandService {

	DataResult<List<Brand>> getAll();
	DataResult<Brand> getById(int brandId);
	Result add(CreateBrandRequest createBrandRequest);
	Result delete(DeleteBrandRequest deleteBrandRequest);
	Result update(UpdateBrandRequest updateBrandRequest);
}
