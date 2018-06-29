package com.javamongodb.dataaccess.model.bindingmodel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CarModel {
    private String model;

    private int year;

    private int odometer;
}
