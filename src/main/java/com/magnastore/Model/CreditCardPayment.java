package com.magnastore.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.magnastore.Constraints.ExpiryDate;

@Entity
@PrimaryKeyJoinColumn( name = "idPayment" )
public class CreditCardPayment extends Payment implements Serializable {
	
	//============================== Constants ==============================//
	
	private static final long serialVersionUID = 8094140020592162677L;
	
	//============================== Attributes ==============================//
	
	@NotEmpty
	private String holderName;
	
	@Size(min=16 , max=30)
	@NotNull
	private String cardNumber;
	
	@ExpiryDate
	private String expiryDate;

	//============================== Constructors ==============================//
	
	public CreditCardPayment() {
		super();
	}

	//============================== Getters and Setter ==============================//
	
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	//============================== Hash, equals, toString ==============================//
	
	@Override
	public String toString() {
		return super.toString() + ", holderName=" + holderName + ", cardNumber=" + cardNumber + ", expiryDate="
				+ expiryDate + "]";
	}
	
	
}
