package com.javamongodb.dataaccess.service;

import com.javamongodb.dataaccess.model.bindingmodel.CarModel;
import com.javamongodb.dataaccess.model.viewmodel.CarViewModel;

import java.util.List;

public interface CarService {
    void create(CarModel carModel);

    void save(CarModel carModel);

    CarViewModel get(String id);

    List<CarViewModel> getAll();

    List<CarViewModel> getAllByYear(int year);
}
