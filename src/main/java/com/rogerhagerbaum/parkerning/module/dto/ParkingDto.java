package com.rogerhagerbaum.parkerning.module.dto;

import com.rogerhagerbaum.parkerning.module.entity.Car;
import com.rogerhagerbaum.parkerning.module.entity.ParkingSpot;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingDto {
    private Long id;
    private ParkingSpot parkingSpot;
    private Car car;
    private LocalDateTime startTime;
    private LocalDateTime updated;
    private LocalDateTime stopTime;
    public boolean isActive = true;
}
