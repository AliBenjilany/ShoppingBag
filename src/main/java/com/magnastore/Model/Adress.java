package com.magnastore.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Adress implements Serializable {
	
	//============================== Constants ==============================//
	
	private static final long serialVersionUID = 7551945436624609605L;
	
	//============================== Attributes ==============================//
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int idAdress;
	
	@Size(min = 5, max = 255)
    @NotNull
	private String adressLine1;
	
	@Size(max = 255)
	private String adressLine2;
	
	@Size(max = 25)
	private String state;
	
	@Size(min = 2, max = 25)
    @NotNull
	private String city;
	
	@Max(99999999)
	@NotNull
	private int zipCode;
	
	@Size(min = 2, max = 25)
	@NotNull
	private String country;
	
	@ManyToOne
	@JoinColumn (name="idUser", nullable = false)
	private UserInformation userInformation;

	
	
	//============================== Constructors ==============================//
	
	public Adress() {}

	public Adress(String adressLine1, String adressLine2, String state, String city, int zipCode, String country,
			UserInformation userInformation) {
		this.adressLine1 = adressLine1;
		this.adressLine2 = adressLine2;
		this.state = state;
		this.city = city;
		this.zipCode = zipCode;
		this.country = country;
		this.userInformation = userInformation;
	}

	//============================== Getters and Setter ==============================//
	

	public int getIdAdress() {
		return idAdress;
	}
	public void setIdAdress(int idAdress) {
		this.idAdress = idAdress;
	}

	
	public String getAdressLine1() {
		return adressLine1;
	}
	public void setAdressLine1(String adressLine1) {
		this.adressLine1 = adressLine1;
	}

	
	public String getAdressLine2() {
		return adressLine2;
	}
	public void setAdressLine2(String adressLine2) {
		this.adressLine2 = adressLine2;
	}

	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	
	public UserInformation getUserInformation() {
		return userInformation;
	}
	public void setUserInformation(UserInformation userInformation) {
		this.userInformation = userInformation;
	}

	
	
	//============================== Hash, equals, toString ==============================//
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adressLine1 == null) ? 0 : adressLine1.hashCode());
		result = prime * result + ((adressLine2 == null) ? 0 : adressLine2.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + zipCode;
		return result;
	}

	@Override
	public String toString() {
		return "Adress [idAdress=" + idAdress + ", adressLine1=" + adressLine1 + ", adressLine2=" + adressLine2
				+ ", state=" + state + ", city=" + city + ", zipCode=" + zipCode + ", country=" + country
				+ ", userInformation=" + userInformation + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adress other = (Adress) obj;
		if (adressLine1 == null) {
			if (other.adressLine1 != null)
				return false;
		} else if (!adressLine1.equals(other.adressLine1))
			return false;
		if (adressLine2 == null) {
			if (other.adressLine2 != null)
				return false;
		} else if (!adressLine2.equals(other.adressLine2))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (zipCode != other.zipCode)
			return false;
		return true;
	}
}
