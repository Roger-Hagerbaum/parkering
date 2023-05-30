package com.rogerhagerbaum.parkerning.module.dto;

import com.rogerhagerbaum.parkerning.module.entity.Car;
import com.rogerhagerbaum.parkerning.module.entity.Parking;
import com.rogerhagerbaum.parkerning.module.entity.ParkingSpot;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ParkingDto {
    private Long id;
    private ParkingSpot parkingSpot;
    private Car car;
    private LocalDateTime startTime;
    private LocalDateTime updated;
    private LocalDateTime stopTime;
    public boolean isActive = true;

    public ParkingDto (Parking p){
        this.id = p.getId();
        this.parkingSpot = p.getParkingSpot();
        this.car = p.getCar();
        this.startTime = p.getStartTime();
        this.updated = p.getUpdated();
        this.stopTime = p.getStopTime();
        this.isActive = p.isActive;
    }
}
