package com.rogerhagerbaum.parkerning.config;

import com.rogerhagerbaum.parkerning.module.entity.Car;
import com.rogerhagerbaum.parkerning.module.entity.ParkingSpot;
import com.rogerhagerbaum.parkerning.module.entity.Person;
import com.rogerhagerbaum.parkerning.repositories.CarRepository;
import com.rogerhagerbaum.parkerning.repositories.ParkingSpotRepository;
import com.rogerhagerbaum.parkerning.repositories.PersonRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

import static org.geolatte.geom.builder.DSL.g;
import static org.geolatte.geom.builder.DSL.point;
import static org.geolatte.geom.crs.CoordinateReferenceSystems.WGS84;

@Slf4j
@Configuration
public class loadDataConfig {

    @Bean
    public CommandLineRunner loadData(ParkingSpotRepository parkingSpotRepository, PersonRepository personRepository, CarRepository carRepository) {
        return args -> {
            Set<Car> foundCar = carRepository.getAll();
            Set<Person> foundPerson = personRepository.getAll();
            Set<ParkingSpot> foundParkingSpot = parkingSpotRepository.getAll();

            if(foundParkingSpot.isEmpty()){
                ParkingSpot i = new ParkingSpot();
                ParkingSpot ic = new ParkingSpot();
                ParkingSpot wil = new ParkingSpot();
                ParkingSpot mel = new ParkingSpot();

                i.setCoordinate(point(WGS84, g(59.652206207568824, 17.085788606296745)));
                ic.setCoordinate(point(WGS84, g(59.652126950530054, 17.08569744605932)));
                wil.setCoordinate(point(WGS84, g(59.65061601460406, 17.086114581867157)));
                mel.setCoordinate(point(WGS84, g(59.64936458360988, 17.086409677065205)));


                parkingSpotRepository.save(i);
                parkingSpotRepository.save(ic);
                parkingSpotRepository.save(wil);
                parkingSpotRepository.save(mel);
            }
            if(foundPerson.isEmpty()){
                Person person1 = new Person();
                Person person2 = new Person();
                Person person3 = new Person();
                Person person4 = new Person();

                person1.setName("Jack");
                person2.setName("Bill");
                person3.setName("Tess");
                person4.setName("Jessica");

                personRepository.save(person1);
                personRepository.save(person2);
                personRepository.save(person3);
                personRepository.save(person4);
            }
            if(foundCar.isEmpty()) {
                Car car1 = new Car();
                Car car2 = new Car();
                Car car3 = new Car();
                Car car4 = new Car();
                Car car5 = new Car();
                Car car6 = new Car();

                car1.setPerson(personRepository.findPersonById(1L));
                car2.setPerson(personRepository.findPersonById(1L));
                car3.setPerson(personRepository.findPersonById(2L));
                car4.setPerson(personRepository.findPersonById(2L));
                car5.setPerson(personRepository.findPersonById(3L));
                car6.setPerson(personRepository.findPersonById(3L));

                car1.setRegistration("HEE232");
                car2.setRegistration("HRR244");
                car3.setRegistration("SDF324");
                car4.setRegistration("DSV947");
                car5.setRegistration("AJD139");
                car6.setRegistration("LVF482");

                carRepository.save(car1);
                carRepository.save(car2);
                carRepository.save(car3);
                carRepository.save(car4);
                carRepository.save(car5);
                carRepository.save(car6);
            }

        };
    }
    }

