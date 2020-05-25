package com.magnastore.Model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class Console {
	

	public static void main(String[] args) {
		
    	//Brand br = new Brand("Yamaha");
		
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
	
		
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("testCon");
			entityManager = entityManagerFactory.createEntityManager();

	//		Product prod = entityManager.find(Product.class,2);
	//		System.out.println(prod.getpBrand().toString());
			
			Category cat = entityManager.find(Category.class, 1);
	//		Category cat = entityManager.find(Category.class, 5);
			System.out.println(cat.getName());
	//		Query query = entityManager.createQuery("from Category where idSuper = null", Category.class);
	//		List<Category> categories = query.getResultList();
			

			
			
	
	//		System.out.println(prod == br.getProduct());
			
	//		List<Product> products = br.getProduct();
			
	//		for (Product product : products) {
	//			System.out.println(product.getpName());
	//		}
			
	//		EntityTransaction trans = entityManager.getTransaction(); 
	//		trans.begin();
	//		
	//		Product p = new Product();
	//		p.setpName("K95 RGB Platinum mechanical gaming keyboard");
			
			//Category newcat = new Category("Accessories", null, entityManager.find(Category.class, 8));
			//entityManager.persist(newcat);
	//		cat.setName("Test");

			
	//		trans.commit();
			
		} finally {
			if(entityManager != null) entityManager.close();
			if(entityManagerFactory != null) entityManagerFactory.close();
		}

	}
	
}
