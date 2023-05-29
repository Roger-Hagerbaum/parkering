package com.rogerhagerbaum.parkerning.repositories;

import com.rogerhagerbaum.parkerning.module.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNullApi;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("select o from Person o where o.id = :id ")
    Person findPersonById(Long id);

}
