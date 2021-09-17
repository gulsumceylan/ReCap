package com.etiya.ReCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.ReCapProject.business.abstracts.CustomerService;
import com.etiya.ReCapProject.business.constants.Messages;
import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.core.utilities.results.Result;
import com.etiya.ReCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.ReCapProject.core.utilities.results.SuccessResult;
import com.etiya.ReCapProject.dataAccess.abstracts.CustomerDao;
import com.etiya.ReCapProject.entities.concretes.ApplicationUser;
import com.etiya.ReCapProject.entities.concretes.Customer;
import com.etiya.ReCapProject.entities.requests.CreateCustomerRequest;
import com.etiya.ReCapProject.entities.requests.DeleteCustomerRequest;
import com.etiya.ReCapProject.entities.requests.UpdateCustomerRequest;
@Service
public class CustomerManager implements CustomerService{

	private CustomerDao customerDao;
	
	@Autowired
	public CustomerManager(CustomerDao customerDao) {
		super();
		this.customerDao = customerDao;
	}

	@Override
	public DataResult<List<Customer>> getAll() {
		
		return new SuccessDataResult<List<Customer>>(this.customerDao.findAll());
	}

	@Override
	public DataResult<Customer> getById(int customerId) {
		return new SuccessDataResult<Customer> (this.customerDao.getById(customerId));
	}

	@Override
	public Result add(CreateCustomerRequest createCustomerRequest) {
		ApplicationUser user=new ApplicationUser();
		user.setId(createCustomerRequest.getUserId());
		
		Customer customer=new Customer();
		customer.setCompanyName(createCustomerRequest.getCompanyName());
		customer.setApplicationUser(user);
		
		this.customerDao.save(customer);
		return new SuccessResult(Messages.ADD);
	}

	@Override
	public Result delete(DeleteCustomerRequest deleteCustomerRequest) {
		ApplicationUser user=new ApplicationUser();
		user.setId(deleteCustomerRequest.getUserId());
		
		Customer customer=new Customer();
		customer.setId(deleteCustomerRequest.getId());
		customer.setCompanyName(deleteCustomerRequest.getCompanyName());
		customer.setApplicationUser(user);
		
		this.customerDao.delete(customer);
		return new SuccessResult(Messages.DELETE);
	}

	@Override
	public Result update(UpdateCustomerRequest updateCustomerRequest) {
		
		ApplicationUser user=new ApplicationUser();
		user.setId(updateCustomerRequest.getUserId());
		
		Customer customer=new Customer();
		customer.setId(updateCustomerRequest.getId());
		customer.setCompanyName(updateCustomerRequest.getCompanyName());
		customer.setApplicationUser(user);
		
		this.customerDao.save(customer);
		return new SuccessResult(Messages.UPDATE);
	}

}