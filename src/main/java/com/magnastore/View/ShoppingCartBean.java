package com.magnastore.View;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.magnastore.Model.Product;
import com.magnastore.Util.CookieHelper;
import com.magnastore.Util.NavigationUtils;


@Named
@RequestScoped
public class ShoppingCartBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7205946004883745230L;
	
	
	@PersistenceContext(unitName = "MagnaStore")
	private EntityManager em;
	
    @Inject
    private CookieHelper cookieHelper;
    
    @Inject
    private NavigationUtils nav;
    
    
    private List<CartItem> items = new ArrayList<>();



 
	@PostConstruct
    public void init() {
    	
    	FacesContext facesContext = FacesContext.getCurrentInstance();
    	HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
    	
    	Cookie[] userCookies = request.getCookies();
    	if(userCookies != null)
    	{
    		for(Cookie c : userCookies)
        	{
        		if(c.getName().contains("Product"))
        		{
        			int quantity = Integer.parseInt(c.getValue());
        			if(quantity > 0)
        			{
            			int id = Integer.parseInt(c.getName().replaceAll("\\D+","")); // to extract numbers only
            			Product p = em.find(Product.class, id);
            			
            			CartItem item = new CartItem();
            			item.setProduct(p);
            			item.setQuantity(quantity);
            			
            			items.add(item);
        			}
        		}
        	}
    	}
    	

    }
	
	public String totalAmount()
	{
		float total = 0;
		for(CartItem item : items)
		{
			total += item.getProduct().getPrice() * item.getQuantity();
		}
		return String.valueOf(total);
	}
    
	
    
    public String addItemToCart(int idProduct) {
    	
    	String name = String.valueOf(idProduct);
    	Cookie cookie = cookieHelper.getProductCookie(name);
    	int value = 1;
    	
    	if( cookie != null)
    	{
    		value = Integer.parseInt(cookie.getValue());
    		value++;
    	}
    	cookieHelper.addCookie("Product" + name, String.valueOf(value), 365 * 24 * 60 *60);
    	nav.refreshor();
    	return null;
    }
    
    
    
    public String itemsInCartCounter()
    {
    	int count = 0;
    	
    	FacesContext facesContext = FacesContext.getCurrentInstance();
    	HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
    	
    	Cookie[] userCookies = request.getCookies();
    	if(userCookies != null)
    	{
    		for(Cookie c : userCookies)
        	{
        		if(c.getName().contains("Product"))
        		{
        			if(Integer.parseInt(c.getValue()) > 0)
        			{
        				count++;
        			}	
        		}
        	}
    	}

    	return String.valueOf(count);
    }

    
    
    // Will reduce the quantity of product if "wholeCookie == false"
    // Will delete the cookie/whole product from cookies if "wholeCookie"  
    public String removeItemFromCart(int productId, Boolean wholeCookie) { 
    	
    	Cookie cookie = cookieHelper.getProductCookie(String.valueOf(productId));
    	int value = Integer.parseInt(cookie.getValue());
    	
    	if( cookie != null && value > 1 && !wholeCookie)
    	{    		
    		value--;
    		cookieHelper.addCookie("Product" + String.valueOf(productId), String.valueOf(value), 365 * 24 * 60 * 60); 
    	}
    	else 
    	{
    		// We can't destroy cookie, so we create new one with same name
    		// then give it value 0, and its max age to 0
    		cookieHelper.addCookie("Product" + String.valueOf(productId), String.valueOf(0), 0); 
    	}
    	nav.refreshor();
    	return null;
    }
    
    
    
	public List<CartItem> getItems() {
		return items;
	}


	public void setItems(List<CartItem> items) {
		this.items = items;
	}

}
