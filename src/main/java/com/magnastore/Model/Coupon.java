package com.magnastore.Model;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Entity
@NamedQueries({
	@NamedQuery(name = Coupon.FIND_BY_COUPON, query = "SELECT c from Coupon c WHERE c.coupon = :coupon")
})
public class Coupon implements Serializable{
	
	//============================== Constants ==============================//
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6273520407479507982L;
	
	public static final String FIND_BY_COUPON = "Coupon.findByCoupon";

	//============================== Attributes ==============================//
	
	

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCoupon;
	
	@Column(length=8, nullable = false)
	private String coupon;
	
	@Temporal(TIMESTAMP)
	@Future
	private Date expiryDate;
	
	@NotNull
	private float discount; //Si positif [0.01,1]  discount percent, si negatif discount brut 

	@Null
	private Integer maxUsesRemaining; // null == infinite
	
	@NotNull
	private Boolean isForProduct; // if false it's for category
	
	@NotNull
	private int idDestination; // if isForProduct == true, this var receives idProduct, else it receives idCategory
	
	@OneToMany (targetEntity = Order.class, mappedBy="coupon")
	private List<Order> orders;
	
	//============================== Constructors ==============================//
	
	public Coupon() {}


	public Coupon(String coupon, Date expiryDate, Integer maxUsesRemaining, Boolean isForProduct, int idDestination) {
		super();
		this.coupon = coupon;
		this.expiryDate = expiryDate;
		this.maxUsesRemaining = maxUsesRemaining;
		this.isForProduct = isForProduct;
		this.idDestination = idDestination;
	}


	//============================== Getters and Setter ==============================//
	public int getIdCoupon() {
		return idCoupon;
	}




	public void setIdCoupon(int idCoupon) {
		this.idCoupon = idCoupon;
	}




	public String getCoupon() {
		return coupon;
	}




	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}




	public Date getExpiryDate() {
		return expiryDate;
	}




	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	
	
	public float getDiscount() {
		return discount;
	}


	public void setDiscount(float discount) {
		this.discount = discount;
	}


	public Integer getMaxUsesRemaining() {
		return maxUsesRemaining;
	}




	public void setMaxUsesRemaining(Integer maxUsesRemaining) {
		this.maxUsesRemaining = maxUsesRemaining;
	}




	public Boolean getIsForProduct() {
		return isForProduct;
	}




	public void setIsForProduct(Boolean isForProduct) {
		this.isForProduct = isForProduct;
	}




	public int getIdDestination() {
		return idDestination;
	}




	public void setIdDestination(int idDestination) {
		this.idDestination = idDestination;
	}




	public List<Order> getOrders() {
		return orders;
	}




	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}


	//============================== Hash, equals, toString ==============================//
	
	@Override
	public String toString() {
		return "Coupon [idCoupon=" + idCoupon + ", coupon=" + coupon + ", expiryDate=" + expiryDate
				+ ", maxUsesRemaining=" + maxUsesRemaining + ", isForProduct=" + isForProduct + ", idDestination="
				+ idDestination + ", orders=" + orders + "]";
	}

	
}
