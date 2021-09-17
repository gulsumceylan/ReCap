package com.etiya.ReCapProject.business.abstracts;

import java.util.List;

import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.core.utilities.results.Result;

import com.etiya.ReCapProject.entities.concretes.Customer;
import com.etiya.ReCapProject.entities.requests.CreateCustomerRequest;
import com.etiya.ReCapProject.entities.requests.DeleteCustomerRequest;
import com.etiya.ReCapProject.entities.requests.UpdateCustomerRequest;

public interface CustomerService {
	
	DataResult<List<Customer>> getAll();
	DataResult<Customer> getById(int customerId);
	Result add(CreateCustomerRequest createCustomerRequest);
	Result delete(DeleteCustomerRequest deleteCustomerRequest);
	Result update(UpdateCustomerRequest updateCustomerRequest);
}