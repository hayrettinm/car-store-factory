package com.hayrettinm.carstorefactory.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDto {

    @Null
    private UUID id;

    @NotBlank
    private String carName;

    @NotBlank
    private String carStyle;

    @Positive
    private Long chasisNo;
}