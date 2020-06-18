package com.magnastore.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

@Entity
public class Shipment implements Serializable{
	
	//============================== Constants ==============================//
	
	private static final long serialVersionUID = 9090583753020247982L;
	
	//============================== Attributes ==============================//
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idShipment;
	
	@NotEmpty
	private String shippingType;
	
	@Temporal(TemporalType.DATE)
	@FutureOrPresent
	private  Date deliveryEstimationDate;
	
	@NotNull
	private Boolean isShipped;
	
	@Temporal(TemporalType.TIMESTAMP)
	@PastOrPresent
	@Column(nullable = true)
	private Date shippedDate;
	
	@NotEmpty
	private String shipmentTracking;
	
	@ManyToOne
	@JoinColumn (name="idAdress", nullable = true)
	private Adress adress;
	
	@OneToOne
	@JoinColumn (name="idOrder", nullable = false)
	private Order order;
	
	//============================== Constructors ==============================//
	
	public Shipment() {	}

	public Shipment(int idShipment, String shippingType, Date deliveryEstimationDate, Boolean isShipped,
			Date shippedDate, String shipmentTracking, Adress adress, Order order) {
		super();
		this.idShipment = idShipment;
		this.shippingType = shippingType;
		this.deliveryEstimationDate = deliveryEstimationDate;
		this.isShipped = isShipped;
		this.shippedDate = shippedDate;
		this.shipmentTracking = shipmentTracking;
		this.adress = adress;
		this.order = order;
	}

	//============================== Getters and Setter ==============================//
	
	public int getIdShipment() {
		return idShipment;
	}
	public void setIdShipment(int idShipment) {
		this.idShipment = idShipment;
	}

	
	public String getShippingType() {
		return shippingType;
	}
	public void setShippingType(String shippingType) {
		this.shippingType = shippingType;
	}

	
	public Date getDeliveryEstimationDate() {
		return deliveryEstimationDate;
	}
	public void setDeliveryEstimationDate(Date deliveryEstimationDate) {
		this.deliveryEstimationDate = deliveryEstimationDate;
	}

	
	public Boolean getIsShipped() {
		return isShipped;
	}
	public void setIsShipped(Boolean isShipped) {
		this.isShipped = isShipped;
	}

	
	public Date getShippedDate() {
		return shippedDate;
	}
	public void setShippedDate(Date shippedDate) {
		this.shippedDate = shippedDate;
	}

	
	public String getShipmentTracking() {
		return shipmentTracking;
	}
	public void setShipmentTracking(String shipmentTracking) {
		this.shipmentTracking = shipmentTracking;
	}

	
	public Adress getAdress() {
		return adress;
	}
	public void setAdress(Adress adress) {
		this.adress = adress;
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
		return "Shipment [idShipment=" + idShipment + ", shippingType=" + shippingType + ", deliveryEstimationDate="
				+ deliveryEstimationDate + ", isShipped=" + isShipped + ", shippedDate=" + shippedDate
				+ ", shipmentTracking=" + shipmentTracking + ", adress=" + adress + ", order=" + order + "]";
	}
}
