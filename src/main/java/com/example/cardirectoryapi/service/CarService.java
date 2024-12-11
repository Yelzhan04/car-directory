package com.example.cardirectoryapi.service;

import com.example.cardirectoryapi.dto.CarDTO;

import java.util.List;
import java.util.Optional;


public interface CarService {
    CarDTO createCar(CarDTO carDTO);
    Optional<CarDTO> getCarById(String id);
    List<CarDTO> getAllCars();
    void deleteCarById(String id);
    CarDTO updateCar(String id,CarDTO carDTO);
}

