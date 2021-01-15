package com.hayrettinm.carstorefactory.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hayrettinm.carstorefactory.service.CarService;
import com.hayrettinm.carstorefactory.web.model.CarDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CarController.class)
class CarControllerTest {

    @MockBean
    CarService carService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    CarDto validCar;

    @BeforeEach
    void setUp() {
        validCar = CarDto.builder()
                .id(UUID.randomUUID())
                .carName("Car1")
                .carStyle("STYLE_1")
                .chasisNo(-123456789L)
                .build();
    }

    @Test
    void getCar() throws Exception {
        given(carService.getCarById(any(UUID.class))).willReturn(validCar);

        mockMvc.perform(get("/api/v1/car/" + validCar.getId().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(validCar.getId().toString())))
                .andExpect(jsonPath("$.carName", is("Car1")));
    }

    @Test
    void handlePost() throws Exception {
        CarDto carDto = validCar;
        carDto.setId(null);
        CarDto savedDto = CarDto.builder().id(UUID.randomUUID()).carName("New Car").build();

        String carDtoJson = objectMapper.writeValueAsString(carDto);

        given(carService.saveNewCar(any())).willReturn(savedDto);

        mockMvc.perform(post("/api/v1/car/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(carDtoJson))
                .andExpect(status().isCreated());
    }

    @Test
    void handleUpdate() throws Exception {

        CarDto carDto = validCar;
        carDto.setId(null);
        String carDtoJson = objectMapper.writeValueAsString(carDto);


        mockMvc.perform(put("/api/v1/car/" + UUID.randomUUID())
                .contentType(MediaType.APPLICATION_JSON)
                .content(carDtoJson))
                .andExpect(status().isNoContent());

        then(carService).should().updateCar(any(), any());

    }
}