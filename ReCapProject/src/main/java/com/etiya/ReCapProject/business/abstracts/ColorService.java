package com.etiya.ReCapProject.business.abstracts;

import java.util.List;

import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.core.utilities.results.Result;
import com.etiya.ReCapProject.entities.concretes.Color;
import com.etiya.ReCapProject.entities.requests.CreateColorRequest;
import com.etiya.ReCapProject.entities.requests.DeleteColorRequest;
import com.etiya.ReCapProject.entities.requests.UpdateColorRequest;

public interface ColorService {

	DataResult<List<Color>> getAll();
	DataResult<Color> getById(int colorId);
	Result add(CreateColorRequest createColorRequest);
	Result delete(DeleteColorRequest deleteColorRequest);
	Result update(UpdateColorRequest updateColorRequest);
}
