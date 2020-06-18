package com.magnastore.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.magnastore.Constraints.ExpiryDate;

@Entity
public class CreditCard implements Serializable {
	
	//============================== Constants ==============================//
	
	private static final long serialVersionUID = 4297215247925117779L;
	
	//============================== Attributes ==============================//
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCard;
	
	@NotEmpty
	private String holderName;
	
	@Size(min=16 , max=30)
	@NotNull
	private String cardNumber;
	
	@ExpiryDate
	private String expiryDate;
	
	@Column(length = 3)
	@NotNull
	private String cvv;
	
	@ManyToOne
	@JoinColumn (name="idUser", nullable = false)
	private UserInformation userInformation;
	//============================== Constructors ==============================//
	
	public CreditCard() {}
	public CreditCard(String holderName, String cardNumber, String expiryDate, String cvv,
			UserInformation userInformation) {
		this.holderName = holderName;
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.cvv = cvv;
		this.userInformation = userInformation;
	}
	
	//============================== Getters and Setter ==============================//
	
	public int getIdCard() {
		return idCard;
	}
	public void setIdCard(int idCard) {
		this.idCard = idCard;
	}
	
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
	
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	
	public UserInformation getUserInformation() {
		return userInformation;
	}
	public void setUserInformation(UserInformation userInformation) {
		this.userInformation = userInformation;
	}
	
	//============================== Hash, equals, toString ==============================//
	
	@Override
	public String toString() {
		return "CreditCard [idCard=" + idCard + ", holderName=" + holderName + ", cardNumber=" + cardNumber
				+ ", expiryDate=" + expiryDate + ", cvv=" + cvv + ", userInformation=" + userInformation + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardNumber == null) ? 0 : cardNumber.hashCode());
		result = prime * result + ((cvv == null) ? 0 : cvv.hashCode());
		result = prime * result + ((expiryDate == null) ? 0 : expiryDate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreditCard other = (CreditCard) obj;
		if (cardNumber == null) {
			if (other.cardNumber != null)
				return false;
		} else if (!cardNumber.equals(other.cardNumber))
			return false;
		if (cvv == null) {
			if (other.cvv != null)
				return false;
		} else if (!cvv.equals(other.cvv))
			return false;
		if (expiryDate == null) {
			if (other.expiryDate != null)
				return false;
		} else if (!expiryDate.equals(other.expiryDate))
			return false;
		return true;
	}
	
	
}
