package com.javamongodb.dataaccess.model.viewmodel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CarViewModel {
    private String id;

    private String model;

    private int year;

    private int odometer;
}
