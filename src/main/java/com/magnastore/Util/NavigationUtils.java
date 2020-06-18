package com.magnastore.Util;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@Dependent
public class NavigationUtils implements Serializable {

	
    /**
	 * 
	 */
	private static final long serialVersionUID = 7448614363743927055L;

	// after returning a string to jsf on the other methods so it can redirect to the concerned page
    // it doesn't fully refresh the page
    // So this redirector act as a refreshor as he loads the page from the back end
	public void refreshor()
    {
		FacesContext context = FacesContext.getCurrentInstance();
    	HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();

    	try {
			context.getExternalContext().redirect(request.getRequestURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
