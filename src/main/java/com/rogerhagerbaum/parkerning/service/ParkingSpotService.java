package com.rogerhagerbaum.parkerning.service;

import com.rogerhagerbaum.parkerning.exceptionHandling.EntityException;
import com.rogerhagerbaum.parkerning.module.dto.ParkingSpotDto;
import com.rogerhagerbaum.parkerning.module.entity.ParkingSpot;
import com.rogerhagerbaum.parkerning.repositories.ParkingSpotRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ParkingSpotService {
    ModelMapper modelMapper;
    ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotDto addParkingSpot(ParkingSpotDto parkingSpotDto) {
        ParkingSpot createNew = modelMapper.map(parkingSpotDto, ParkingSpot.class);
        createNew.setCoordinate(parkingSpotDto.getCoordinate());
        parkingSpotRepository.save(createNew);

        return modelMapper.map(createNew, ParkingSpotDto.class);
    }
    public List<ParkingSpotDto> getAll(){
        Set<ParkingSpot> parkingSpots;
        parkingSpots = parkingSpotRepository.getAll();
        return parkingSpots.stream()
                .map(ParkingSpotDto::new)
                .collect(Collectors.toList());
    }
    public ParkingSpotDto getById(Long id){
        ParkingSpot parkingSpot = parkingSpotRepository.findParkingSpotById(id);
        if (parkingSpot == null){
            throw new EntityException(String.format("ParkingSpot: %d not found", id), HttpStatus.NOT_FOUND);
        }
        return modelMapper.map(parkingSpot , ParkingSpotDto.class);
    }
    public ParkingSpotDto deletePerson(Long id) {
        ParkingSpot parkingSpot = parkingSpotRepository.findParkingSpotById(id);
        if (parkingSpot == null){
            throw new EntityException(String.format("ParkingSpot: %d not found", id), HttpStatus.NOT_FOUND);
        }
        parkingSpotRepository.delete(parkingSpot);
        return modelMapper.map(parkingSpot, ParkingSpotDto.class);
    }
}
