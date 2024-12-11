package com.example.cardirectoryapi.service.impl;

import com.example.cardirectoryapi.dto.CarDTO;
import com.example.cardirectoryapi.repository.CarRepository;
import com.example.cardirectoryapi.service.CarService;
import com.example.cardirectoryapi.util.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }
    @Override
    public CarDTO createCar(CarDTO carDTO) {
        var car = carMapper.carDTOToEntity(carDTO);
        var savedCar = carRepository.save(car);
        return carMapper.carEntityToDTO(savedCar);
    }

    @Override
    public Optional<CarDTO> getCarById(String id) {
        return carRepository.findById(id).map(carMapper::carEntityToDTO);
    }

    @Override
    public List<CarDTO> getAllCars() {
        var cars = carRepository.findAll();
        return cars.stream().map(carMapper::carEntityToDTO).collect(Collectors.toList());

    }

    @Override
    public void deleteCarById(String id) {
        carRepository.deleteById(id);
    }

    @Override
    public CarDTO updateCar(String id, CarDTO carDTO) {
        var existingCar = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found with id: " + id)); // Обработка ошибки

        existingCar.setMake(carDTO.getMake());
        existingCar.setModel(carDTO.getModel());
        existingCar.setYear(carDTO.getYear());
        existingCar.setPrice(carDTO.getPrice());
        existingCar.setVin(carDTO.getVin());

        var updatedCar = carRepository.save(existingCar);
        return carMapper.carEntityToDTO(updatedCar);
    }

}
