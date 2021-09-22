package com.etiya.ReCapProject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="credit_cards")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class CreditCard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="credit_card_id")
	private int creditCardId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="card_number")
	private String cardNumber;
	
	@Column(name="expiry_Date")
	private String expiryDate; 
	
	@Column(name="cvv")
	@Size(min=3, max=3)
	private String cvv;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
}
