package com.rogerhagerbaum.parkerning.service;

import com.rogerhagerbaum.parkerning.module.dto.ParkingDto;
import com.rogerhagerbaum.parkerning.module.dto.ParkingSpotDto;
import com.rogerhagerbaum.parkerning.module.entity.Parking;
import com.rogerhagerbaum.parkerning.module.entity.ParkingSpot;
import com.rogerhagerbaum.parkerning.repositories.CarRepository;
import com.rogerhagerbaum.parkerning.repositories.ParkingRepository;
import com.rogerhagerbaum.parkerning.repositories.ParkingSpotRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ParkingService {
    ModelMapper modelMapper;
    ParkingRepository parkingRepository;
    CarRepository carRepository;
    ParkingSpotRepository parkingSpotRepository;

    public ParkingDto startParking(ParkingDto parkingDto) {
        Parking createNew = modelMapper.map(parkingDto, Parking.class);
        parkingRepository.save(createNew);
        return modelMapper.map(createNew, ParkingDto.class);
    }
    public List<ParkingDto> getAll(){
        Set<Parking> parking;
        parking = parkingRepository.getAll();
        return parking.stream()
                .map(ParkingDto::new)
                .collect(Collectors.toList());
    }
    public ParkingDto getById(int id){
        Parking parking = parkingRepository.findParkingById(id);
        return modelMapper.map(parking , ParkingDto.class);
    }
    public List<ParkingDto> findParkingStatus(int carPersonId,boolean aktivInactiv){
        Set<Parking> parking;
        int r =carPersonId;
        parking = parkingRepository.getAllByActive(aktivInactiv);
        return parking.stream()
                .map(ParkingDto::new)
                .collect(Collectors.toList());
    }
    public ParkingDto updateParking(int id, LocalDateTime uppdateTime) {
        Parking update = parkingRepository.findParkingById(id);
        update.setStopTime(uppdateTime);
        parkingRepository.save(update);
        return modelMapper.map(update , ParkingDto.class);
    }

}
