package com.rogerhagerbaum.parkerning.controller;

import com.rogerhagerbaum.parkerning.module.dto.CarDto;
import com.rogerhagerbaum.parkerning.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
@AllArgsConstructor
public class CarController {
    private final CarService carService;
    @PostMapping("/{personId}")
    public ResponseEntity<CarDto> addCar(@RequestBody CarDto carDto , @PathVariable Long personId) {
        return new ResponseEntity<>(carService.addCar(carDto, personId), HttpStatus.CREATED);
    }
    @GetMapping("")
    public ResponseEntity<List<CarDto>>getAll(@RequestParam (required = false) Long personId) {
        return new ResponseEntity<>(carService.getAll(personId), HttpStatus.OK);
    }
    @GetMapping("/{carId}")
    public ResponseEntity<CarDto> findById(@PathVariable int carId) {
        return new ResponseEntity<>(carService.getById(carId), HttpStatus.OK);
    }
    @DeleteMapping("/{carId}")
    public ResponseEntity<CarDto>  deleteCar(@PathVariable int carId) {
        return new ResponseEntity<>(carService.deleteCar(carId), HttpStatus.OK);

    }
}
