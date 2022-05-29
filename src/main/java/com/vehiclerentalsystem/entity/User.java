package com.vehiclerentalsystem.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="user_tbl")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="user_address")
	private String address;
	
	@Column(name="user_phoneNumber")
	private String phoneNumber;
	
	@Column(name="user_email")
	private String email;
	
	@Column(name="login_password")
	private String password;
	
	@OneToMany(mappedBy ="user")
	private List<Car>listOfCars;
	
	@OneToMany(mappedBy ="user")
	private List<Booking>listOfBookings;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public List<Car> getListOfCars() {
		return listOfCars;
	}

	public void setListOfCars(List<Car> listOfCars) {
		this.listOfCars = listOfCars;
	}

	public List<Booking> getListOfBookings() {
		return listOfBookings;
	}

	public void setListOfBookings(List<Booking> listOfBookings) {
		this.listOfBookings = listOfBookings;
	}
	


	
}
