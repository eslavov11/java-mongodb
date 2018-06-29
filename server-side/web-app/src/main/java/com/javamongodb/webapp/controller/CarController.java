package com.javamongodb.webapp.controller;

import com.javamongodb.dataaccess.model.bindingmodel.CarModel;
import com.javamongodb.dataaccess.model.viewmodel.CarViewModel;
import com.javamongodb.dataaccess.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by eslavov on 29-Jun-18.
 */
@RestController
@RequestMapping(value = "/api/cars", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarController {
    private CarService service;

    @Autowired
    public CarController(CarService service) {
        this.service = service;
    }

    @PostMapping("/add")
    //@PreAuthorize("hasRole('ADMIN')")
    public void add(@RequestBody CarModel carModel) {
        this.service.create(carModel);
    }

    @PutMapping("/edit")
    //@PreAuthorize("hasRole('ADMIN')")
    public void edit(@RequestBody CarModel carModel) {
        this.service.save(carModel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarViewModel> get(@PathVariable String id) {
        CarViewModel carViewModel = this.service.get(id);

        if (carViewModel == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(carViewModel, HttpStatus.OK);
    }

    @GetMapping("")
    public List<CarViewModel> getAll() {
        return this.service.getAll();
    }

    @GetMapping("")
    public List<CarViewModel> getAllByDate(int year) {
        return this.service.getAllByYear(year);
    }
}
