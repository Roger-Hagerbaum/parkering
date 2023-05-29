package com.rogerhagerbaum.parkerning.config;

import com.rogerhagerbaum.parkerning.module.entity.ParkingSpot;
import com.rogerhagerbaum.parkerning.repositories.ParkingSpotRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.geolatte.geom.builder.DSL.g;
import static org.geolatte.geom.builder.DSL.point;
import static org.geolatte.geom.crs.CoordinateReferenceSystems.WGS84;

@Slf4j
@Configuration
public class loadDataConfig {

    @Bean
    public CommandLineRunner loadData(ParkingSpotRepository parkingSpotRepository) {
        return args -> {
            var i = new ParkingSpot();
            var ic = new ParkingSpot();
            var wil = new ParkingSpot();
            var mel = new ParkingSpot();

            i.setCoordinate(point(WGS84, g(59.652206207568824, 17.085788606296745)));
            ic.setCoordinate(point(WGS84, g(59.652126950530054, 17.08569744605932)));
            wil.setCoordinate(point(WGS84, g(59.65061601460406, 17.086114581867157)));
            mel.setCoordinate(point(WGS84, g(59.64936458360988, 17.086409677065205)));


            parkingSpotRepository.save(i);
            parkingSpotRepository.save(ic);
            parkingSpotRepository.save(wil);
            parkingSpotRepository.save(mel);

        };
    }
    }

