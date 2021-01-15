package com.hayrettinm.carstorefactory.service;

import com.hayrettinm.carstorefactory.web.model.CarDto;

import java.util.UUID;

public interface CarService {
    CarDto getCarById(UUID carId);

    CarDto saveNewCar(CarDto carDto);

    void updateCar(UUID carId, CarDto carDto);

    void deleteById(UUID carId);
}
