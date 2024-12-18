package com.example.demo.Entity;


import java.io.Serializable;

import jakarta.persistence.*;

@Entity
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String carName;
    private String carModel;
    private String price;
    @Lob
    private byte[] image;

    @ManyToOne
    @JoinColumn(name = "dealerId")
    private Dealer dealer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	public Car(Long id, String carName, String carModel, String price, byte[] image, Dealer dealer) {
		super();
		this.id = id;
		this.carName = carName;
		this.carModel = carModel;
		this.price = price;
		this.image = image;
		this.dealer = dealer;
	}

	public Car() {
		super();
	}

    
    
}

