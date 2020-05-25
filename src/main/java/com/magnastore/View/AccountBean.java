package com.magnastore.View;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.magnastore.Model.User;


public class AccountBean {
	
	@PersistenceContext(unitName = "MagnaStore")
	private EntityManager em;
	
	private User user;


}
