//package com.magnastore.Util;
//
//import javax.faces.application.FacesMessage;
//import javax.faces.context.FacesContext;
//import javax.faces.event.PhaseEvent;
//import javax.faces.event.PhaseId;
//import javax.faces.event.PhaseListener;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.web.WebAttributes;
// 
//public class LoginErrorPhaseListener implements PhaseListener
//{
//    private static final long serialVersionUID = -1216620620302322995L;
// 
//    protected final Log logger = LogFactory.getLog(getClass());
//    
//    @Override
//    public void beforePhase(final PhaseEvent arg0)
//    {
//    	Exception e = (Exception) FacesContext.getCurrentInstance().
//    	          getExternalContext().getSessionMap().get(WebAttributes.AUTHENTICATION_EXCEPTION);
//    	 
//    	        if (e instanceof BadCredentialsException) {
//    	            logger.debug("Found exception in session map: "+e);
//    	            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(
//    	                    WebAttributes.AUTHENTICATION_EXCEPTION, null);
//    	            FacesContext.getCurrentInstance().addMessage(null,
//    	              new FacesMessage(FacesMessage.SEVERITY_ERROR,
//    	                "Username or password not valid.", "Username or password not valid"));
//    	        }
//    }
// 
//    @Override
//    public void afterPhase(final PhaseEvent arg0)
//    {}
// 
//    @Override
//    public PhaseId getPhaseId()
//    {
//        return PhaseId.RENDER_RESPONSE;
//    }
// 
//}