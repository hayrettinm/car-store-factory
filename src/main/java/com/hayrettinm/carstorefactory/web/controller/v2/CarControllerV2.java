package com.hayrettinm.carstorefactory.web.controller.v2;

import com.hayrettinm.carstorefactory.service.v2.CarServiceV2;
import com.hayrettinm.carstorefactory.web.model.v2.CarDtoV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Validated
@RequestMapping("/api/v2/car")
@RestController
public class CarControllerV2 {

    private final CarServiceV2 carService;

    public CarControllerV2(CarServiceV2 carService) {
        this.carService = carService;
    }

    @GetMapping({"/{carId}"})
    public ResponseEntity<CarDtoV2> getCar(@NotNull  @PathVariable("carId") UUID carId){
        return new ResponseEntity<>(carService.getCarById(carId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@Valid @RequestBody CarDtoV2 carDto){
        CarDtoV2 savedDto = carService.saveNewCar(carDto);

        HttpHeaders headers= new HttpHeaders();
        headers.add("Location", "/api/v1/car/"+ savedDto.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{carId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleUpdate(@PathVariable("carId") UUID carId, @Valid @RequestBody CarDtoV2 carDto){

        carService.updateCar(carId, carDto);
    }

    @DeleteMapping({"/{carId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCar(@PathVariable("carId")UUID carId){
        carService.deleteById(carId);

    }
}
