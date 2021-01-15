package com.hayrettinm.carstorefactory.web.controller;

import com.hayrettinm.carstorefactory.service.CarService;
import com.hayrettinm.carstorefactory.web.model.CarDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@Deprecated
@RequestMapping("/api/v1/car")
@RestController
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping({"/{carId}"})
    public ResponseEntity<CarDto> getCar(@PathVariable("carId") UUID carId){
        return new ResponseEntity<>(carService.getCarById(carId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost (@Valid @RequestBody CarDto carDto){
        CarDto savedDto = carService.saveNewCar(carDto);

        HttpHeaders headers= new HttpHeaders();
        headers.add("Location", "/api/v1/car/"+ savedDto.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{carId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleUpdate(@PathVariable("carId") UUID carId, @Valid @RequestBody CarDto carDto){

        carService.updateCar(carId, carDto);
    }

    @DeleteMapping({"/{carId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCar(@PathVariable("carId")UUID carId){
        carService.deleteById(carId);

    }
}
