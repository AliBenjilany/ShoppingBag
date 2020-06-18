package com.magnastore.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Complaint implements Serializable {

	//============================== Constants ==============================//
	
	private static final long serialVersionUID = 2948650435775310709L;
	
	//============================== Attributes ==============================//
	
	@Id @GeneratedValue( strategy=GenerationType.IDENTITY)
	private int idComplaint;
	
	@NotEmpty
	private String title;
	
	@NotEmpty
	private String body;
	
	@ManyToOne
	@JoinColumn(name="idUser", nullable = false)
	private UserInformation userInformation;
	
	//============================== Constructors ==============================//
	
	public Complaint() {}

	public Complaint(String title, String body, UserInformation userInformation) {
		this.title = title;
		this.body = body;
		this.userInformation = userInformation;
	}
	
	//============================== Getters and Setter ==============================//
	
	public int getIdComplaint() {
		return idComplaint;
	}
	public void setIdComplaint(int idComplaint) {
		this.idComplaint = idComplaint;
	}

	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}

	
	public UserInformation getUserInformation() {
		return userInformation;
	}
	public void setUserInformation(UserInformation userInformation) {
		this.userInformation = userInformation;
	}

	//============================== Hash, equals, toString ==============================//

	@Override
	public String toString() {
		return "Complaint [idComplaint=" + idComplaint + ", title=" + title + ", body=" + body + ", userInformation="
				+ userInformation + "]";
	}	
	
}
