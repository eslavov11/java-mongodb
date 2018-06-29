package com.javamongodb.dataaccess.repository;

import com.javamongodb.dataaccess.entity.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by eslavov on 29-Jun-18.
 */
public interface CarRepository extends MongoRepository<Car, String> {
    List<Car> findAllByYear(int year);
}
