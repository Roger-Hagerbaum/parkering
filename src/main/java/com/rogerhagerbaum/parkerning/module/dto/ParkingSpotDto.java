package com.rogerhagerbaum.parkerning.module.dto;

import com.rogerhagerbaum.parkerning.module.entity.Parking;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingSpotDto {
    private Long id;
    private Point<G2D> coordinate;
    private Set<Parking> parkingEvent;
}
