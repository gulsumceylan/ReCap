package com.etiya.ReCapProject.business.abstracts;

import java.util.List;

import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.core.utilities.results.Result;
import com.etiya.ReCapProject.entities.dtos.ApplicationUserDetailDto;
import com.etiya.ReCapProject.entities.requests.user.CreateUserRequest;
import com.etiya.ReCapProject.entities.requests.user.DeleteUserRequest;

public interface UserService {
	

	DataResult<List<ApplicationUserDetailDto>> getAll();
	DataResult<ApplicationUserDetailDto> getById(int userId);
	Result add(CreateUserRequest createUserRequest);
	Result delete(DeleteUserRequest deleteUserRequest);

}
