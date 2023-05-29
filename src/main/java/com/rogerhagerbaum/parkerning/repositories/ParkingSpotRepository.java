package com.rogerhagerbaum.parkerning.repositories;

import com.rogerhagerbaum.parkerning.module.entity.ParkingSpot;
import com.rogerhagerbaum.parkerning.module.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Long> {
    @Query("select o from ParkingSpot o where o.id = :id ")
    ParkingSpot findParkingSpotById(Long id);
    @Query("select o from ParkingSpot o ")
    Set<ParkingSpot> getAll();
    ParkingSpot findParkingSpotById(int id);

}
