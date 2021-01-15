package com.hayrettinm.carstorefactory.service;

import com.hayrettinm.carstorefactory.web.model.CarDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CarServiceImpl implements CarService {
    @Override
    public CarDto getCarById(UUID carId) {
        return CarDto.builder()
                .id(carId)
                .carName("Clio IV")
                .carStyle("HatchBack")
                .build();
    }

    @Override
    public CarDto saveNewCar(CarDto carDto) {
        return CarDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateCar(UUID carId, CarDto carDto) {

    }

    @Override
    public void deleteById(UUID carId) {
        log.debug("Deleting car : {}", carId );
    }
}
