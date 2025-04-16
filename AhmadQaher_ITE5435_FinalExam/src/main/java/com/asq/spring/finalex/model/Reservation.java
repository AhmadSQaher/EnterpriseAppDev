package com.asq.spring.finalex.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "reservations")
public class Reservation {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private int numberOfPassengers;
    private String classType;
    private String phoneNumber;
    private String time;
    private String dateOfDeparting;

    
    
    public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
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



	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}



	public void setNumberOfPassengers(int numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}



	public String getClassType() {
		return classType;
	}



	public void setClassType(String classType) {
		this.classType = classType;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getTime() {
		return time;
	}



	public void setTime(String time) {
		this.time = time;
	}



	public String getDateOfDeparting() {
		return dateOfDeparting;
	}



	public void setDateOfDeparting(String dateOfDeparting) {
		this.dateOfDeparting = dateOfDeparting;
	}



	public Reservation(String firstName, String lastName, int numberOfPassengers, String classType, String phoneNumber, String time, String dateOfDeparting) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberOfPassengers = numberOfPassengers;
        this.classType = classType;
        this.phoneNumber = phoneNumber;
        this.time = time;
        this.dateOfDeparting = dateOfDeparting;
    }
}