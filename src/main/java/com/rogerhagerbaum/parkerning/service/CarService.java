package com.rogerhagerbaum.parkerning.service;

import com.rogerhagerbaum.parkerning.exceptionHandling.EntityException;
import com.rogerhagerbaum.parkerning.module.dto.CarDto;
import com.rogerhagerbaum.parkerning.module.entity.Car;
import com.rogerhagerbaum.parkerning.module.entity.Person;
import com.rogerhagerbaum.parkerning.repositories.CarRepository;
import com.rogerhagerbaum.parkerning.repositories.PersonRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class CarService {
    ModelMapper modelMapper;
    PersonRepository personRepository;
    CarRepository carRepository;

    public CarDto addCar(CarDto carDto , Long personId){
        Car createNew = modelMapper.map(carDto, Car.class);
        Person person = personRepository.findPersonById(personId);
        if (person == null){
            throw new EntityException(String.format("Person: %d not found", personId), HttpStatus.NOT_FOUND);
        }
        createNew.setPerson(person);
        carRepository.save(createNew);
        System.out.println(createNew.getPerson().getId());
        return modelMapper.map(createNew , CarDto.class);
    }
    public List<CarDto> getAll(){
        Set<Car> cars = carRepository.getAll();
        return cars.stream()
                .map(CarDto::new)
                .collect(Collectors.toList());
    }

    public CarDto getById(Long id){
        Car car = carRepository.findCarById(id);
        if (car == null){
            throw new EntityException(String.format("Car: %d not found", id), HttpStatus.NOT_FOUND);
        }
        return modelMapper.map(car , CarDto.class);
    }
    public CarDto deleteCar(Long id) {
        Car car = carRepository.findCarById(id);
        if (car == null){
            throw new EntityException(String.format("Car: %d not found", id), HttpStatus.NOT_FOUND);
        }
        carRepository.delete(car);
        return modelMapper.map(car, CarDto.class);
    }

}
