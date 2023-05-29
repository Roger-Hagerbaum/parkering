package com.rogerhagerbaum.parkerning.service;

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
        createNew.setPerson(person);
        carRepository.save(createNew);
        System.out.println(createNew.getPerson().getId());
        return modelMapper.map(createNew , CarDto.class);
    }
    public List<CarDto> getAll(Long personId){
        Set<Car> cars;
        if(personId != null){
            cars = carRepository.findByPersonId(personId);
        }else {
            cars = carRepository.getAll();
        }
        return cars.stream()
                .map(CarDto::new)
                .collect(Collectors.toList());
    }

    public CarDto getById(int id){
        Car car = carRepository.findCarById(id);
        TypeMap<Car, CarDto> propertyMapper = this.modelMapper.createTypeMap(Car.class, CarDto.class);
        propertyMapper.addMappings(mapper -> mapper.skip(CarDto::setPerson));
        return modelMapper.map(car , CarDto.class);
    }
    public CarDto deleteCar(int id) {
        Car car = carRepository.findCarById(id);
        carRepository.delete(car);
        return modelMapper.map(car, CarDto.class);
    }

}
