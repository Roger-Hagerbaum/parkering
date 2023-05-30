package com.rogerhagerbaum.parkerning.controller;

import com.rogerhagerbaum.parkerning.module.dto.ParkingSpotDto;
import com.rogerhagerbaum.parkerning.module.dto.PersonDto;
import com.rogerhagerbaum.parkerning.service.ParkingSpotService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking-spot")
@AllArgsConstructor
public class ParkingSpotController {
    private final ParkingSpotService parkingSpotService;

    @PostMapping
    public ResponseEntity<ParkingSpotDto> addParkingSpot(@RequestBody ParkingSpotDto parkingSpotDto){
        return new ResponseEntity<>(parkingSpotService.addParkingSpot(parkingSpotDto), HttpStatus.OK);
    }
    @GetMapping("")
    public ResponseEntity<List<ParkingSpotDto>>getAll() {
        return new ResponseEntity<>(parkingSpotService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{parkingSpotId}")
    public ResponseEntity<ParkingSpotDto> findById(@PathVariable Long parkingSpotId) {
        return new ResponseEntity<>(parkingSpotService.getById(parkingSpotId), HttpStatus.OK);
    }
    @DeleteMapping("/{parkingSpotId}")
    public ResponseEntity<ParkingSpotDto>  deleteParkingSpot(@PathVariable int parkingSpotId) {
        return new ResponseEntity<>(parkingSpotService.deletePerson(parkingSpotId), HttpStatus.OK);

    }
}
