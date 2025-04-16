package com.asq.spring.finalex.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "payments")
public class Payment {
    @Id
    private String id;
    private int amount;
    private String classType;

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public Payment(int amount, String classType) {
        this.amount = amount;
        this.classType = classType;
    }

    public int calculatePrice(int numberOfPassengers) {
        switch (classType) {
            case "economy":
                return numberOfPassengers * 800;
            case "business":
                return numberOfPassengers * 1000;
            case "first":
                return numberOfPassengers * 1500;
            default:
                return 0;
        }
    }
}