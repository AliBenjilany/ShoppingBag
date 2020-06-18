package com.magnastore.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
public class ProductImage implements Serializable {
	
	//============================== Constants ==============================//
	
	private static final long serialVersionUID = -2340283141952207195L;

	//============================== Attributes ==============================//
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Size(min = 1, max = 255)
	private String path;
	
	@ManyToOne @JoinColumn(name="idProduct", nullable=false)
	private Product product;
	
	//============================== Constructors ==============================//
	
	public ProductImage () {}

	public ProductImage(String path, Product product) {
		super();
		this.path = path;
		this.product = product;
	}

	//============================== Getters and Setter ==============================//
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

	//============================== Hash, equals, toString ==============================//
	
	@Override
	public String toString() {
		return "ProductImage [id=" + id + ", path=" + path + ", product=" + product + "]";
	}
	
	

}
