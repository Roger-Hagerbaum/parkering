package com.rogerhagerbaum.parkerning.repositories;

import com.rogerhagerbaum.parkerning.module.entity.Car;
import com.rogerhagerbaum.parkerning.module.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

public interface CarRepository extends JpaRepository<Car, Long>{
    @Query("select o from Car o where o.id = :id ")
    Car findCarById(Long id);
    @Query("select o from Car o ")
    Set<Car> getAll();
    @Query("select o from Car o where o.id = :id ")
    Set<Car> CarByPerson(Long id);


}
