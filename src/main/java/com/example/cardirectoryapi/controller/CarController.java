package com.example.cardirectoryapi.controller;

import com.example.cardirectoryapi.dto.CarDTO;
import com.example.cardirectoryapi.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<List<CarDTO>> getAllCars() {
        var cars = carService.getAllCars();
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> getCarById(@PathVariable String id) {
        return carService.getCarById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<CarDTO> createCar(@RequestBody CarDTO carDTO) {
        var createCar = carService.createCar(carDTO);
        return ResponseEntity.ok(createCar);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CarDTO> updateCar(@PathVariable String id, @RequestBody CarDTO carDTO) {
        var updateCar = carService.updateCar(id, carDTO);
        return ResponseEntity.ok(updateCar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable String id) {
        carService.deleteCarById(id);
        return ResponseEntity.noContent().build();
    }


}
