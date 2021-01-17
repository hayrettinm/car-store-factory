package com.hayrettinm.carstorefactory.web.mapper;

import com.hayrettinm.carstorefactory.domain.Car;
import com.hayrettinm.carstorefactory.web.model.CarDto;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface CarMapper {
    CarDto carToCarDto(Car car);

    Car carDtoToCar(CarDto carDto);
}
