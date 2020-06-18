package com.magnastore.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Category implements Serializable {
	
	//============================== Constants ==============================//
	
	private static final long serialVersionUID = 2445821337938873843L;

	//============================== Attributes ==============================//
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCategory;
	
	@Size(max=50)
	@NotEmpty
	private String name;

	@Size(max = 50)
	private String description;	
	
	@ManyToOne
	@JoinColumn (name="idSuper")
	private Category superCategory; //Exclude SuperCategory from toString to avoid infinite recursive loop
	
	@OneToMany(mappedBy="superCategory", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Category> subCategories;
	
	@OneToMany(targetEntity=Product.class, mappedBy="category", cascade = CascadeType.ALL)
	private List<Product> products;
	
	//============================== Constructors ==============================//
	
	public Category () {}

	public Category(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public Category(String name, String description, Category superCategory) {
		this.name = name;
		this.description = description;
		this.superCategory = superCategory;
	}

	//============================== Getters and Setter ==============================//
	
	public int getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	//Exclude SuperCategory from toString to avoid infinite recursive loop
	public Category getSuperCategory() {
		return superCategory;
	}
	public void setSuperCategory(Category superCategory) {
		this.superCategory = superCategory;
	}

	
	public List<Category> getSubCategories() {
		return subCategories;
	}
	public void setSubCategories(List<Category> subCategories) {
		this.subCategories = subCategories;
	}

	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	//============================== Hash, equals, toString ==============================//
	
	//Exclude SuperCategory from toString to avoid infinite recursive loop
	@Override
	public String toString() {
		
		return "\nCategory [\n\tidCategory=" + idCategory + ",\n\tname=" + name + ", \n\tdescription=" + description
				+ ", \n\tsuperCategory="  + ", \n\tsubCategories=" + subCategories + ", \n\tproducts=" + products
				+ "\n]";
	}
	
}
