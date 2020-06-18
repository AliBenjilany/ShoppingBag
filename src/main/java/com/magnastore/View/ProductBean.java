package com.magnastore.View;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import com.magnastore.Model.Product;

@Named
@RequestScoped
public class ProductBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3937815996747723764L;
	
	
	@PersistenceContext(unitName = "MagnaStore")
	private EntityManager em;
	
	private List<Product> products;
	
	
	
	@PostConstruct
    public void getAllProducts() {
        TypedQuery<Product> typedQuery = em.createNamedQuery(Product.FIND_ALL, Product.class);
        
        setProducts(typedQuery.getResultList());
    }

    
    
    
	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
