package com.magnastore.View;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.magnastore.Model.Product;
import com.magnastore.Model.User;
import com.magnastore.Model.UserInformation;
import com.magnastore.Util.NavigationUtils;

@Named
@RequestScoped
public class WishlistBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 409862898234929909L;
	
	@Inject
    private NavigationUtils nav;
	
	@PersistenceContext(unitName = "MagnaStore")
	private EntityManager em;
		
	private User user;
	
	private Set<Product> products = new HashSet<>();
	
	@PostConstruct
	public void init()
	{
		String username = null;
		
		//Get authenticated username
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		} else {
			username = principal.toString();
		}
		
		user = null;
		//get user from username
		try {
			TypedQuery<User> typedQuery = em.createNamedQuery(User.FIND_BY_USERNAME, User.class);
			typedQuery.setParameter("username", username);
			user = typedQuery.getSingleResult();
		} catch (Exception e) {}
		
		if(user != null)
		{	
			//load wishlist into local products list
			products = user.getUserInformation().getWishList();
		}
	}
	
	@Transactional
	public String addToWishlist(int idProduct)
	{
		Boolean exists = false;
		
		for(Product p : products)
		{
			if(p.getIdProduct() == idProduct)
			{
				exists = true;
				break;
			}
		}
		if(!exists)
		{

//				products.add(em.find(Product.class, idProduct));
//				
//				UserInformation userInfo = em.find(UserInformation.class, user.getIdUser());
//				userInfo.setWishList(products);
//				em.merge(user);
				
				try {
					Query query = (Query) em.createNativeQuery("INSERT INTO wishlist_product_associations VALUES ( ? , ? )");
					query.setParameter(1,user.getIdUser());
					query.setParameter(2,idProduct);
					query.executeUpdate();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
//				em.getTransaction().begin();
//				Product p = em.find(Product.class, 6);
//				p.setDescription("Best running short !");
//				em.merge(p);
//				em.getTransaction().commit();
	
		}
		
		nav.refreshor();
		return null;
	}
	
	@Transactional
	public String removeFromWishlist(int idProduct)
	{
		try {
			Query query = (Query) em.createNativeQuery("DELETE FROM wishlist_product_associations WHERE idUser = ? AND idProduct = ?");
			query.setParameter(1,user.getIdUser());
			query.setParameter(2,idProduct);
			query.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		nav.refreshor();
		return null;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
