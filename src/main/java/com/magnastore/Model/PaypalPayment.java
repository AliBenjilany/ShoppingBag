package com.magnastore.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotEmpty;

@Entity
@PrimaryKeyJoinColumn( name = "idPayment" )
public class PaypalPayment extends Payment implements Serializable {

	//============================== Constants ==============================//
	
	private static final long serialVersionUID = 5377635900271319243L;
	
	//============================== Attributes ==============================//
	
	@NotEmpty
	private String accountNumber;

	//============================== Constructors ==============================//
	
	private PaypalPayment() {
		super();
	}
	
	//============================== Getters and Setter ==============================//

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	//============================== Hash, equals, toString ==============================//
	
	@Override
	public String toString() {
		return super.toString() + ", accountNumber=" + accountNumber + "]";
	}
	

	

}
