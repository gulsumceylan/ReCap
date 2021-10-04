package com.etiya.ReCapProject.business.abstracts;

import java.util.List;

import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.core.utilities.results.Result;
import com.etiya.ReCapProject.entities.dtos.ColorDetailDto;
import com.etiya.ReCapProject.entities.requests.create.CreateColorRequest;
import com.etiya.ReCapProject.entities.requests.delete.DeleteColorRequest;
import com.etiya.ReCapProject.entities.requests.update.UpdateColorRequest;

public interface ColorService {

	DataResult<List<ColorDetailDto>> getAll();
	DataResult<ColorDetailDto> getById(int colorId);
	Result add(CreateColorRequest createColorRequest);
	Result delete(DeleteColorRequest deleteColorRequest);
	Result update(UpdateColorRequest updateColorRequest);
}
