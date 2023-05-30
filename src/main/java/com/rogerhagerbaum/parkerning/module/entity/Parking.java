package com.rogerhagerbaum.parkerning.module.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ParkingSpot parkingSpot;

    @ManyToOne
    private Car car;

    @CreationTimestamp
    private LocalDateTime startTime;

    @UpdateTimestamp
    private LocalDateTime updated;

    @Column(nullable = false)
    private LocalDateTime stopTime;

    public boolean isActive = true;

}
