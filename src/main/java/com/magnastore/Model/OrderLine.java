package com.magnastore.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class OrderLine implements Serializable {
	
	//============================== Constants ==============================//

	private static final long serialVersionUID = 5455845547664445683L;

	//============================== Attributes ==============================//
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOrderLine;
	
	@Min(1)
	private int quantity;
	
	@NotNull
	@Positive
	private float priceAtOrderTime;
	
	@ManyToOne
	@JoinColumn (name="idProduct", nullable = false)
	private Product product;
	
	@ManyToOne
	@JoinColumn (name="idOrder")
	private Order order;
	
	//============================== Constructors ==============================//
	
	public OrderLine() {}

	public OrderLine(Product product, int priceAtOrderTime, int quantity, Order order) {
		this.product = product;
		this.priceAtOrderTime = priceAtOrderTime;
		this.quantity = quantity;
		this.order = order;
	}
	
	//============================== Getters and Setter ==============================//

	public int getIdOrderLine() {
		return idOrderLine;
	}
	public void setIdOrderLine(int idOrderLine) {
		this.idOrderLine = idOrderLine;
	}

	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

	
	public float getPriceAtOrderTime() {
		return priceAtOrderTime;
	}
	public void setPriceAtOrderTime(float priceAtOrderTime) {
		this.priceAtOrderTime = priceAtOrderTime;
	}

	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
		return "OrderLine [idOrderLine=" + idOrderLine + ", product=" + product + ", priceAtOrderTime="
				+ priceAtOrderTime + ", quantity=" + quantity + ", order=" + order + "]";
	}
	
}
