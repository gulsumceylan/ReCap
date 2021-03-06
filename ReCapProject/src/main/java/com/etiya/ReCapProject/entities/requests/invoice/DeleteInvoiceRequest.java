package com.etiya.ReCapProject.entities.requests.invoice;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeleteInvoiceRequest {
	
	@NotNull
	private int invoiceId;
	
}
