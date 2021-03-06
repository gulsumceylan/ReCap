package com.etiya.ReCapProject.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CorporateCustomerDetailDto {
	private int id;
	
	private String companyName;
	
	private String taxNumber;
}
