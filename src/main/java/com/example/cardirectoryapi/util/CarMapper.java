package com.example.cardirectoryapi.util;


import com.example.cardirectoryapi.dto.CarDTO;
import com.example.cardirectoryapi.model.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    public static Car carDTOToEntity(CarDTO carDTO) {
        Car car = new Car();
        car.setMake(carDTO.getMake());
        car.setModel(carDTO.getModel());
        car.setYear(carDTO.getYear());
        car.setPrice(carDTO.getPrice());
        car.setVin(carDTO.getVin());
        return car;
    }

    public CarDTO carEntityToDTO(Car car) {
        return new CarDTO(
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getPrice(),
                car.getVin()
        );
    }
}
