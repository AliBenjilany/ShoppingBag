package com.magnastore.Model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity @Table(name="Users")
public class User implements Serializable {
	
	//============================== Constants ==============================//
	
	private static final long serialVersionUID = 1574420984559470583L;
	    
	//============================== Attributes ==============================//
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUser;
	
    @Size(min=4 , max = 25)
    @NotNull
	private String username;
	
	@Email
	private String email;
	
	@NotEmpty
	private String password;
	
	@NotNull
	private Boolean enabled;
	
	private String disableReason;

	@OneToOne(mappedBy = "user" , cascade = CascadeType.ALL)
	private UserInformation userInformation;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Authority Authoritiy;
	

	
	//============================== Constructors ==============================//
	
	public User() {}
	
	public User(String username, String email, String password, UserInformation userInformation, Authority authoritiy) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.userInformation = userInformation;
		Authoritiy = authoritiy;
	}

	
	//============================== Getters and Setter ==============================//
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	public UserInformation getUserInformation() {
		return userInformation;
	}
	public void setUserInformation(UserInformation userInformation) {
		this.userInformation = userInformation;
	}

	
	public Authority getAuthoritiy() {
		return Authoritiy;
	}
	public void setAuthoritiy(Authority authoritiy) {
		Authoritiy = authoritiy;
	}
	
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	
	public String getDisableReason() {
		return disableReason;
	}
	public void setDisableReason(String disableReason) {
		this.disableReason = disableReason;
	}

	//============================== Hash, equals, toString ==============================//
	
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", enabled=" + enabled + ", disableReason=" + disableReason + ", userInformation=" + userInformation
				+ ", Authoritiy=" + Authoritiy + "]";
	}
	
}
