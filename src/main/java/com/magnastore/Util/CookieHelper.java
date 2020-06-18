package com.magnastore.Util;

import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Dependent
public class CookieHelper {
	
    
	public void addCookie(String name, String value, int expiry) {
    	
    	FacesContext facesContext = FacesContext.getCurrentInstance();
    	HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
    	
    	Cookie cookie = null;

        Cookie[] userCookies = request.getCookies();
        if (userCookies != null && userCookies.length > 0 ) {
            for (int i = 0; i < userCookies.length; i++) {
                if (userCookies[i].getName().equals(name)) {
                    cookie = userCookies[i];
                    break;
                }
            }
        }
    	
    	if(cookie != null)
    	{
    		cookie.setValue(value);
    	} else
    	{
    		cookie = new Cookie(name, value);
    		cookie.setPath(request.getContextPath());
    	}
    	cookie.setMaxAge(expiry);
    	HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
    	response.addCookie(cookie);
    }
    
    
    
    public Cookie getProductCookie(String name)
    {
    	FacesContext facesContext = FacesContext.getCurrentInstance();
    	HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
    	
    	Cookie cookie = null;
    	
    	Cookie[] userCookies = request.getCookies();
    	
    	if(userCookies != null && userCookies.length > 0)
    	{
    		for (int i = 0; i < userCookies.length; i++)
    		{
    			if(userCookies[i].getName().equals("Product"+name))
    			{
    				cookie = userCookies[i];
        			return cookie;
    			}
    		}
    	}
    	return null;
    }
    
    
}
