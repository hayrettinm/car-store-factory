package com.hayrettinm.carstorefactory.domain;

import com.hayrettinm.carstorefactory.web.model.v2.CarModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car {
    private UUID id;
    private String carName;
    private CarModel carModel;
    private Long chasisNo;

    private Timestamp createdDate;
    private Timestamp lastUpdateDate;
}
