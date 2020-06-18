package com.magnastore.Util;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.magnastore.Model.Category;
import com.magnastore.Model.Coupon;
import com.magnastore.Model.Product;
import com.magnastore.View.CartItem;


@Dependent
public class CouponUtils implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3728972648537239203L;
	
	@PersistenceContext(unitName = "MagnaStore")
	private EntityManager em;
	
	public Coupon findCoupon(String coupon)
	{
		if(coupon != null)
		{
			coupon.toUpperCase();
			
	        try {
				TypedQuery<Coupon> query = em.createNamedQuery(Coupon.FIND_BY_COUPON, Coupon.class);
				query.setParameter("coupon", coupon);
				
				return query.getSingleResult();
			} catch (NoResultException e) {
				return null;
			}
		}
		return null;
	}
	
	public Boolean checkValidity(Coupon coupon)
	{
		if(coupon == null)
			return false;

		Date now = new Date();
		if(coupon.getExpiryDate().after(now))
		{
			if(coupon.getMaxUsesRemaining() == null || coupon.getMaxUsesRemaining().compareTo(0) > 0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		return false;
		
	}
	
	public float calculateDiscountPerItem(Coupon c, Product p)
    {
    	float discount = 0;
   
		// check if the discount is percent ( > 0 ) or brut ( < 0 )
		if(c.getDiscount() > 0)
		{
			discount += p.getPrice() * c.getDiscount();
		}
		else if(c.getDiscount() < 0)
		{
			discount -= c.getDiscount();
		}
		return discount;
    }
	
	public float calculateTotalDiscount(List<CartItem> products, List<Coupon> coupons)
    {
    	float discount = 0;
    	for(Coupon c : coupons)
    	{
    		if(checkValidity(c))
        	{
    			for(CartItem p : products)
    	    	{	//Check if the coupon is destinated for product == true, or for category == false
    	    		if(c.getIsForProduct())
    	    		{	//check if the coupon applicable for the products in cart
    	    			if(c.getIdDestination() == p.getProduct().getIdProduct())
    	    			{	
    	    				float sum = calculateDiscountPerItem(c,p.getProduct()) * p.getQuantity();
    	    				discount += sum;
    	    			}
    	    		}
    	    		else
    	    		{	//check if the product belongs to the category or its supers
    	    			Category cat = p.getProduct().getCategory();
    	    			do {
    	    				if(c.getIdDestination() == cat.getIdCategory())
    	    				{	
    	    					float sum = calculateDiscountPerItem(c,p.getProduct()) * p.getQuantity();
    	    					discount += sum;
    	    					break;
    	    				}
    	    				cat = cat.getSuperCategory();
    	    			}while(cat.getIdCategory() != 0 && cat.getSuperCategory() != null);
    	    			
    	    		}
    	    	}
        	}
    	}
    	
    	return discount;
    }
}
