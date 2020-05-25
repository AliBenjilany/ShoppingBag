package com.magnastore.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Review implements Serializable {

	//============================== Constants ==============================//
	
	private static final long serialVersionUID = 8172498461514362638L;
	
	//============================== Attributes ==============================//
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReview;
	
	@Min(0)
	@Max(5)
	@NotNull
	private float reviewStars;
	
	private String comment;
	
	@NotNull
	private Boolean TargetProductOwnerVerified;

	@ManyToOne
	@JoinColumn(name="idProduct", nullable = false)
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="idUser", nullable = false)
	private UserInformation userInformation;

	//============================== Constructors ==============================//
	
	public Review() {}

	public Review(float reviewStars, String comment, Boolean targetProductOwnerVerified, Product product,
			UserInformation userInformation) {
		this.reviewStars = reviewStars;
		this.comment = comment;
		TargetProductOwnerVerified = targetProductOwnerVerified;
		this.product = product;
		this.userInformation = userInformation;
	}
	
	//============================== Getters and Setter ==============================//
	
	public int getIdReview() {
		return idReview;
	}
	public void setIdReview(int idReview) {
		this.idReview = idReview;
	}

	
	public float getReviewStars() {
		return reviewStars;
	}
	public void setReviewStars(float reviewStars) {
		this.reviewStars = reviewStars;
	}

	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	
	public Boolean getTargetProductOwnerVerified() {
		return TargetProductOwnerVerified;
	}
	public void setTargetProductOwnerVerified(Boolean targetProductOwnerVerified) {
		TargetProductOwnerVerified = targetProductOwnerVerified;
	}

	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
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
		return "Review [idReview=" + idReview + ", reviewStars=" + reviewStars + ", comment=" + comment
				+ ", TargetProductOwnerVerified=" + TargetProductOwnerVerified + ", product=" + product
				+ ", userInformation=" + userInformation + "]";
	}
	
}
