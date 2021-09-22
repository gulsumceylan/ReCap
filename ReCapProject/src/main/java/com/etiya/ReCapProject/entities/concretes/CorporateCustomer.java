package com.etiya.ReCapProject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="corporate_customer")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class CorporateCustomer extends Customer {
	@NotNull
	@Column(name="company_name")
	private String companyName;
	
	@NotNull
	@Column(name="tax_number")
	private String taxNumber;
	
}
