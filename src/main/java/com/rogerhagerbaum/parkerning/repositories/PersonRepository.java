package com.rogerhagerbaum.parkerning.repositories;

import com.rogerhagerbaum.parkerning.module.entity.Car;
import com.rogerhagerbaum.parkerning.module.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNullApi;

import java.util.Set;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("select o from Person o where o.id = :id ")
    Person findPersonById(Long id);
    @Query("select o from Person o ")
    Set<Person> getAll();
    Person findPersonById(int id);
}
