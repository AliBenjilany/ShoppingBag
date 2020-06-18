package com.magnastore.View;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.magnastore.Model.Coupon;
import com.magnastore.Util.CouponUtils;
import com.magnastore.Util.NavigationUtils;

@Named
@SessionScoped
public class CheckoutBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4302986988053497496L;

	private String coupon;
	
	@Inject
	private NavigationUtils nav;
	
    @Inject
    private CouponUtils couponUtils;
    
	private List<Coupon> coupons = new ArrayList<>();
	
	
    public void applyCoupon() {
    	
    	Coupon cp = couponUtils.findCoupon(coupon);
    	if(cp == null)
    	{
    		// error message here coupon not found
    		//return null;
    	}
    	else 
    	{
    		if(couponUtils.checkValidity(cp))
    		
    		{
    			Boolean exist = false;
    			
	    		for(Coupon c : coupons)
	    		{
	    			if(c.getCoupon().equals(cp.getCoupon()))
	    			{
	    				exist = true;
	    			}
	    		}
	    		if(!exist)
	    		{
	    			coupons.add(cp);
	    		}
    		}
    	}
    	
    	nav.refreshor();
    	//return null;
    }
    
    public float couponsDiscount(List<CartItem> products)
    {
    	
    	return couponUtils.calculateTotalDiscount(products, coupons);
    }
    
	public String getCoupon() {
		return coupon;
	}

	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}
    
}
