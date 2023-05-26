package com.rogerhagerbaum.parkerning.module.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@ToString
public class ParkingSpot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Point<G2D> coordinate;

    @OneToMany(mappedBy = "parkingSpot")
    private Set<Parking> parkingEvent = new HashSet<>();
}