package com.javamongodb.dataaccess.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
public class Car {
    @Id
    private String id;

    private String model;

    private int year;

    private int odometer;
}
