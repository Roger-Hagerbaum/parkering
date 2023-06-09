package com.rogerhagerbaum.parkerning.controller;

import com.rogerhagerbaum.parkerning.module.dto.ParkingDto;
import com.rogerhagerbaum.parkerning.module.dto.ParkingSpotDto;
import com.rogerhagerbaum.parkerning.service.ParkingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/parking")
@AllArgsConstructor
public class ParkingController {
    private final ParkingService parkingService;
    @PostMapping
    public ResponseEntity<ParkingDto> startParking(@RequestBody ParkingDto parkingDto){
        return new ResponseEntity<>(parkingService.startParking(parkingDto), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<ParkingDto>>getAll() {
        return new ResponseEntity<>(parkingService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{parkingId}")
    public ResponseEntity<ParkingDto> findById(@PathVariable Long parkingId) {
        return new ResponseEntity<>(parkingService.getById(parkingId), HttpStatus.OK);
    }
    @GetMapping("/{carId}/{aktivStatus}")
    public ResponseEntity<List<ParkingDto>>findParkingStatus(@PathVariable  Long carId, @PathVariable boolean aktivStatus) {


        return new ResponseEntity<>(parkingService.findParkingStatus(carId,aktivStatus), HttpStatus.OK);
    }
    @PatchMapping("/{parkingId}/{updateTime}")
    public ResponseEntity<ParkingDto> updateParking(@PathVariable Long parkingId,
                                                    @PathVariable LocalDateTime updateTime) {
        return new ResponseEntity<>(parkingService.updateParking(parkingId, updateTime), HttpStatus.OK);
    }

}
