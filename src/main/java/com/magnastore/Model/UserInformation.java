package com.magnastore.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class UserInformation implements Serializable {
	
	//============================== Constants ==============================//
	
	private static final long serialVersionUID = -3042747239270071189L;
	
	//============================== Attributes ==============================//
	
	@Id
	private int idUser;
	
	@Size(min=2 , max=25)
	@NotNull
	private String firstName;
	
	@Size(min=2 , max=25)
	@NotNull
	private String lastName;
	
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	
	@Size(min=10 , max=15)
	private String phoneNumber;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLogon;
	
	@OneToOne
	@JoinColumn (name="idUser", nullable = false)
	@MapsId
	private User user;
	
	@OneToMany (targetEntity = Adress.class, mappedBy="userInformation", cascade = CascadeType.ALL)
	private List<Adress> adresses;
	
	@OneToMany (targetEntity = Order.class, mappedBy="userInformation")
	private List<Order> orders;
	
	@OneToMany (targetEntity = CreditCard.class, mappedBy="userInformation", cascade = CascadeType.ALL)
	private List<CreditCard> creditCards;
	
	@OneToMany (targetEntity = Review.class, mappedBy="userInformation", cascade = CascadeType.ALL)
	private List<Review> reviews;
	
	@OneToMany (targetEntity = Complaint.class, mappedBy="userInformation", cascade = CascadeType.ALL)
	private List<Complaint> complaints;
	
	@ManyToMany
    @JoinTable( name = "WishList_Product_Associations",
                joinColumns = @JoinColumn( name = "idUser" ),
                inverseJoinColumns = @JoinColumn( name = "idProduct" ) )
	private List<Product> wishList;
	
	//============================== Constructors ==============================//
	
	public UserInformation() {}

	public UserInformation(int idUser, String firstName, String lastName, Date birthDate, String phoneNumber,
			Date lastLogon, User user) {
		this.idUser = idUser;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.phoneNumber = phoneNumber;
		this.lastLogon = lastLogon;
		this.user = user;
	}
	
	//============================== Getters and Setter ==============================//
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
	public Date getLastLogon() {
		return lastLogon;
	}
	public void setLastLogon(Date lastLogon) {
		this.lastLogon = lastLogon;
	}

	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	
	public List<Adress> getAdresses() {
		return adresses;
	}
	public void setAdresses(List<Adress> adresses) {
		this.adresses = adresses;
	}

	
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	
	public List<CreditCard> getCreditCards() {
		return creditCards;
	}
	public void setCreditCards(List<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}
	
	
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
	public List<Complaint> getComplaints() {
		return complaints;
	}

	public void setComplaints(List<Complaint> complaints) {
		this.complaints = complaints;
	}
	
	public List<Product> getProducts() {
		return wishList;
	}

	public void setProducts(List<Product> products) {
		this.wishList = products;
	}
	
	//============================== Hash, equals, toString ==============================//

	@Override
	public String toString() {
		return "UserInformation [idUser=" + idUser + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", birthDate=" + birthDate + ", phoneNumber=" + phoneNumber + ", lastLogon=" + lastLogon + ", user="
				+ user + ", adresses=" + adresses + ", orders=" + orders + ", creditCards=" + creditCards + "]";
	}

}
