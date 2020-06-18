package com.magnastore.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity @Table(name="Authorities")
public class Authority implements Serializable {

	//============================== Constants ==============================//
	private static final long serialVersionUID = -9043196830969451908L;
	
	//============================== Attributes ==============================//

	@Id
	@OneToOne
	@JoinColumn (name="username", nullable = false)
	private User user;
	
	@Enumerated
	private UserRole authority;
	
	//============================== Constructors ==============================//
	
	public Authority() {}

	public Authority(UserRole authority) {
		this.authority = authority;
	}
	
	//============================== Getters and Setter ==============================//
	
	public User getUsers() {
		return user;
	}
	public void setUsers(User user) {
		this.user = user;
	}

	
	public UserRole getAuthority() {
		return authority;
	}
	public void setAuthority(UserRole authority) {
		this.authority = authority;
	}
	
	//============================== Hash, equals, toString ==============================//
	
	@Override
	public String toString() {
		return "Authority [users=" + user + ", authority=" + authority + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authority == null) ? 0 : authority.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Authority other = (Authority) obj;
		if (authority == null) {
			if (other.authority != null)
				return false;
		} else if (!authority.equals(other.authority))
			return false;
		return true;
	}
	
}
