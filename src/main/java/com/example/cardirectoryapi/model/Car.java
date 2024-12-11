package com.example.cardirectoryapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "cars",uniqueConstraints = {@UniqueConstraint(columnNames = "vin")})
public class Car {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    @NotBlank(message = "Make cannot be empty")
    private String make;

    @Column(nullable = false)
    @NotBlank(message = "Model cannot be empty")
    private String model;

    @Column(nullable = false)
    @Min(value = 1886, message = "Year cannot be earlier than 1886")
    @Max(value = 2024, message = "Year cannot be later than the current year") // Replace 2024 with `LocalDate.now().getYear()` dynamically if needed
    private int year;

    @Column(nullable = false)
    @DecimalMin(value = "0.01", inclusive = true, message = "Price must be greater than 0")
    private BigDecimal price;

    @Column(nullable = false, length = 17, unique = true)
    @Size(min = 17, max = 17, message = "VIN must be exactly 17 characters long")
    private String vin;

    public Car() {}

    public Car(String make, String model, int year, BigDecimal price, String vin) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.vin = vin;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
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
