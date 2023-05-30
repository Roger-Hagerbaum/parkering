package com.rogerhagerbaum.parkerning.repositories;

import com.rogerhagerbaum.parkerning.module.entity.Parking;
import com.rogerhagerbaum.parkerning.module.entity.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface ParkingRepository extends JpaRepository<Parking, Long> {
    @Query("select o from Parking o where o.id = :id ")
    Parking findParkingById(Long id);
    @Query("select o from Parking o ")
    Set<Parking> getAll();
    @Query("select o from Parking o where o.isActive = :status")
    Set<Parking> getAllByActive(boolean status);


}
