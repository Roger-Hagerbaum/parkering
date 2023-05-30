package com.rogerhagerbaum.parkerning.service;

import com.rogerhagerbaum.parkerning.exceptionHandling.EntityException;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
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
        if(createNew.getStopTime().isBefore(LocalDateTime.now())) {
            throw new EntityException("Time must be after start time!", HttpStatus.BAD_REQUEST);
        }
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
    public ParkingDto getById(Long id){
        Parking parking = parkingRepository.findParkingById(id);
        if (parking == null){
            throw new EntityException(String.format("Parking: %d not found", id), HttpStatus.NOT_FOUND);
        }
        return modelMapper.map(parking , ParkingDto.class);
    }
    public List<ParkingDto> findParkingStatus(Long carId, boolean aktivStatus){
        Set<Parking> parking;
        Set<Parking> filterd = new HashSet<>();
        parking = parkingRepository.getAllByActive(aktivStatus);
        if(carId != null){
        for  (Parking park : parking){
            if(park.getCar().getId().equals(carId)){
                filterd.add(park);
            }
        }
        }else {
            filterd = parking;
        }
        return filterd.stream()
                .map(ParkingDto::new)
                .collect(Collectors.toList());
    }
    public ParkingDto updateParking(Long id, LocalDateTime uppdateTime) {
        Parking update = parkingRepository.findParkingById(id);
        if (update == null){
            throw new EntityException(String.format("Parking: %d not found", id), HttpStatus.NOT_FOUND);
        }else if (uppdateTime.isBefore(update.getStartTime()) || !update.isActive) {
            throw new EntityException("Time must be after start and parking must be active", HttpStatus.BAD_REQUEST);
        }
        update.setStopTime(uppdateTime);
        parkingRepository.save(update);
        return modelMapper.map(update , ParkingDto.class);
    }

}
