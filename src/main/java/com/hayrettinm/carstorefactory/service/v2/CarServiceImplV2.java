package com.hayrettinm.carstorefactory.service.v2;

import com.hayrettinm.carstorefactory.web.model.v2.CarDtoV2;
import com.hayrettinm.carstorefactory.web.model.v2.CarModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CarServiceImplV2 implements CarServiceV2 {
    @Override
    public CarDtoV2 getCarById(UUID carId) {
        return CarDtoV2.builder()
                .id(carId)
                .carName("Clio IV")
                .carModel(CarModel.SEDAN)
                .build();
    }

    @Override
    public CarDtoV2 saveNewCar(CarDtoV2 carDtoV2) {
        return CarDtoV2.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateCar(UUID carId, CarDtoV2 carDtoV2) {

    }

    @Override
    public void deleteById(UUID carId) {
        log.debug("Deleting car : {}", carId );
    }
}
