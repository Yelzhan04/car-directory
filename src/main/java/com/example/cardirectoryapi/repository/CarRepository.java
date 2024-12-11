package com.example.cardirectoryapi.repository;

import com.example.cardirectoryapi.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {

}
