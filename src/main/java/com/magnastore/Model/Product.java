package com.magnastore.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;


@Entity
public class Product implements Serializable {

	//============================== Constants ==============================//
	
	private static final long serialVersionUID = 698175753579471826L;

	//============================== Attributes ==============================//
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProduct;
	
	@NotNull
	@Size(min = 2, max = 50)
	private String name;
	
	@NotEmpty
	private String description;
	
	@Min(1)
	private float price;
	
	@NotNull
	private int stock;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date addedDate;
	
	@ManyToOne 
	@JoinColumn (name="idBrand", nullable = true)
	private Brand brand;
	
	@ManyToOne
	@JoinColumn (name="idCategory", nullable = false)
	private Category category;
	
	
	@OneToMany (targetEntity = ProductImage.class, mappedBy="product", cascade=CascadeType.ALL)
	private List<ProductImage> images;
	
	@OneToMany (targetEntity = Review.class, mappedBy="product", cascade = CascadeType.ALL)
	private List<Review> reviews;
	
	@ManyToMany
    @JoinTable( name = "WishList_Product_Associations",
                joinColumns = @JoinColumn( name = "idProduct" ),
                inverseJoinColumns = @JoinColumn( name = "idUser" ) )
	private List<UserInformation> userInformation;
	
	//============================== Constructors ==============================//
	public Product () {}

	public Product(String name, String description, float price, int stock, Date addedDate, Brand brand, Category category) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.addedDate = addedDate;
		this.brand = brand;
		this.category = category;
	}
	
	//============================== Getters and Setter ==============================//
	
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
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

	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

	
	public Date getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	
	public List<ProductImage> getImages() {
		return images;
	}
	public void setImages(List<ProductImage> images) {
		this.images = images;
	}
	
	
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	//============================== Hash, equals, toString ==============================//
	
	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", name=" + name + ", description=" + description + ", price="
				+ price + ", stock=" + stock + ", addedDate=" + addedDate + ", brand=" + brand + ", category="
				+ category + ", images=" + images + "]";
	}

}
