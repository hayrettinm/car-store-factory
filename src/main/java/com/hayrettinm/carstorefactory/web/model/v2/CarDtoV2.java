package com.hayrettinm.carstorefactory.web.model.v2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDtoV2 {

    private UUID id;
    private String carName;
    private CarModel carModel;
    private Long chasisNo;
}
