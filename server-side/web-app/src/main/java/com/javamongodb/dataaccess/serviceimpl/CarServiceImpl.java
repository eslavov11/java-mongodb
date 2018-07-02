package com.javamongodb.dataaccess.serviceimpl;

import com.javamongodb.dataaccess.entity.Car;
import com.javamongodb.dataaccess.model.bindingmodel.CarModel;
import com.javamongodb.dataaccess.model.viewmodel.CarViewModel;
import com.javamongodb.dataaccess.repository.CarRepository;
import com.javamongodb.dataaccess.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    private ModelMapper modelMapper;
    private CarRepository repository;

    @Autowired
    public CarServiceImpl(ModelMapper modelMapper, CarRepository repository) {
        this.modelMapper = modelMapper;
        this.repository = repository;
    }

    @Override
    public void create(CarModel carModel) {
        Car car = this.modelMapper.map(carModel, Car.class);

        this.repository.save(car);
    }

    @Override
    public void save(CarModel carModel) {
        Car car = this.modelMapper.map(carModel, Car.class);

        this.repository.save(car);
    }

    @Override
    public CarViewModel get(String id) {
        Optional<Car> car = this.repository.findById(id);

        if (!car.isPresent()) {
            return null;
        }

        return this.modelMapper.map(car.get(), CarViewModel.class);
    }

    @Override
    public List<CarViewModel> getAll() {
        List<Car> cars = this.repository.findAll();
        Type targetListType = new TypeToken<List<CarViewModel>>() {}.getType();

        return this.modelMapper.map(cars, targetListType);
    }

    @Override
    public List<CarViewModel> getAllByYear(int year) {
        List<Car> cars = this.repository.findAllByYear(year);
        Type targetListType = new TypeToken<List<CarViewModel>>() {}.getType();

        return this.modelMapper.map(cars, targetListType);
    }
}
