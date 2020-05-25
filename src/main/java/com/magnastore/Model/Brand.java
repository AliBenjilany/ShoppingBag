package com.magnastore.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Brand implements Serializable {
	
	//============================== Constants ==============================//
	
	private static final long serialVersionUID = 8203884891585313708L;

	//============================== Attributes ==============================//
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int idBrand;
	
	@Size(min=2, max=25)
	@NotNull
	private String name;
	
	@OneToMany(targetEntity=Product.class, 
			mappedBy="brand",
			cascade=CascadeType.ALL)
	private List<Product> products;
	
	//============================== Constructors ==============================//

	public Brand () {}

	public Brand(String name) {
		this.name = name;
	}
	
	//============================== Getters and Setter ==============================//
	
	public int getIdBrand() {
		return idBrand;
	}
	public void setIdBrand(int idBrand) {
		this.idBrand = idBrand;
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	//============================== Hash, equals, toString ==============================//
	
	@Override
	public String toString() {
		return "Brand [idBrand=" + idBrand + ", name=" + name + ", products=" + products + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Brand other = (Brand) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	

}
