package com.javamongodb.dataaccess.repository;

import com.javamongodb.dataaccess.entity.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by eslavov on 29-Jun-18.
 */
@Repository
public interface CarRepository extends MongoRepository<Car, String> {
    List<Car> findAllByYear(int year);
}
