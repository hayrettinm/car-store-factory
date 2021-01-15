package com.hayrettinm.carstorefactory.service.v2;

import com.hayrettinm.carstorefactory.web.model.v2.CarDtoV2;

import java.util.UUID;

public interface CarServiceV2 {
    CarDtoV2 getCarById(UUID carId);

    CarDtoV2 saveNewCar(CarDtoV2 carDto);

    void updateCar(UUID carId, CarDtoV2 carDto);

    void deleteById(UUID carId);
}
