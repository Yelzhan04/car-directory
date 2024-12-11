package com.example.cardirectoryapi.dto;

import java.math.BigDecimal;

public class CarDTO {
    private String make;
    private String model;
    private int year;
    private BigDecimal price;
    private String vin;

    public CarDTO(String make, String model, int year, BigDecimal price, String vin) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}
