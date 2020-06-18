package com.magnastore.Model;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public abstract class Payment {
	
	//============================== Constants ==============================//
	

	//============================== Attributes ==============================//
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPayment;
	
	@NotNull
	private double amount;
	
	@Temporal(TIMESTAMP)
	@PastOrPresent
	private Date paymentDate;
	
	@OneToOne
	@JoinColumn (name="idOrder", nullable = false)
	private Order order;
	
	//============================== Constructors ==============================//
	
	public Payment() {}

	public Payment(double amount, Date paymentDate, Order order) {
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.order = order;
	}

	public int getIdPayment() {
		return idPayment;
	}

	public void setIdPayment(int idPayment) {
		this.idPayment = idPayment;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	//============================== Hash, equals, toString ==============================//
	
	@Override
	public String toString() {
		return "Payment [idPayment=" + idPayment + ", amount=" + amount + ", paymentDate=" + paymentDate + ", order="
				+ order + "]";
	}
	
}
