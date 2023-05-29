package com.rogerhagerbaum.parkerning.controller;

import com.rogerhagerbaum.parkerning.module.dto.CarDto;
import com.rogerhagerbaum.parkerning.module.dto.PersonDto;
import com.rogerhagerbaum.parkerning.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@AllArgsConstructor
public class PersonController {
    private final PersonService personService;
    @PostMapping
    public ResponseEntity<PersonDto> addPerson(@RequestBody PersonDto personDto){
        return new ResponseEntity<>(personService.addPerson(personDto), HttpStatus.OK);
    }
    @GetMapping("")
    public ResponseEntity<List<PersonDto>>getAll() {
        return new ResponseEntity<>(personService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{personId}")
    public ResponseEntity<PersonDto> findById(@PathVariable int personId) {
        return new ResponseEntity<>(personService.getById(personId), HttpStatus.OK);
    }
    @DeleteMapping("/{personId}")
    public ResponseEntity<PersonDto>  deleteCar(@PathVariable int personId) {
        return new ResponseEntity<>(personService.deletePerson(personId), HttpStatus.OK);

    }
}
