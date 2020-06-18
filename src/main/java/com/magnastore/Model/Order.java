package com.magnastore.Model;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;

@Entity @Table(name="Orders")
public class Order implements Serializable{
	
	//============================== Constants ==============================//
	
	private static final long serialVersionUID = 4401440829367404997L;
	
	//============================== Attributes ==============================//
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOrder;
	
	
	@NotNull
	@Positive
	private double finalAmount; //After coupon and taxes
	
	@Temporal(TIMESTAMP)
	private Date orderDate;
	
	@NotNull
	private Boolean isCancel;
	
	@Temporal(TIMESTAMP)
	@PastOrPresent
	private Date cancelDate;
	
	@OneToMany (targetEntity = OrderLine.class, mappedBy="order", cascade=CascadeType.ALL)
	@NotEmpty
	private List<OrderLine> items;
	
	@ManyToOne
	@JoinColumn (name="idCoupon", nullable = true)
	private Coupon coupon;
	
	@ManyToOne
	@JoinColumn (name="idUser", nullable = false)
	private UserInformation userInformation;
	
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)	
	private Payment payment;
	
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)	
	private Shipment shipment;
	
	//============================== Constructors ==============================//
	
	public Order(){}

	public Order(double finalAmount, Date orderDate, Boolean isCancel, Date cancelDate,
			UserInformation userInformation, Payment payment, Shipment shipment) {
		this.finalAmount = finalAmount;
		this.orderDate = orderDate;
		this.isCancel = isCancel;
		this.cancelDate = cancelDate;
		this.userInformation = userInformation;
		this.payment = payment;
		this.shipment = shipment;
	}
	
	//============================== Getters and Setter ==============================//
	
	public int getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	
	public Coupon getCoupon() {
		return coupon;
	}
	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}

	
	public double getFinalAmount() {
		return finalAmount;
	}
	public void setFinalAmount(double finalAmount) {
		this.finalAmount = finalAmount;
	}

	
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	
	public Boolean getIsCancel() {
		return isCancel;
	}
	public void setIsCancel(Boolean isCancel) {
		this.isCancel = isCancel;
	}
	
	
	public Date getCancelDate() {
		return cancelDate;
	}	
	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}
	
	
	public List<OrderLine> getItems() {
		return items;
	}
	public void setItems(List<OrderLine> items) {
		this.items = items;
	}
	
	
	public UserInformation getUserInformation() {
		return userInformation;
	}
	public void setUserInformation(UserInformation userInformation) {
		this.userInformation = userInformation;
	}

	
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	
	public Shipment getShipment() {
		return shipment;
	}
	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}
	
	//============================== Hash, equals, toString ==============================//

	@Override
	public String toString() {
		return "Order [idOrder=" + idOrder + ", coupon=" + coupon + ", finalAmount=" + finalAmount + ", orderDate="
				+ orderDate + ", isCancel=" + isCancel + ", cancelDate=" + cancelDate + ", items=" + items
				+ ", userInformation=" + userInformation + ", payment=" + payment + ", shipment=" + shipment + "]";
	}
	
}
