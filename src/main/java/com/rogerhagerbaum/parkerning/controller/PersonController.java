package com.rogerhagerbaum.parkerning.controller;

import com.rogerhagerbaum.parkerning.module.dto.PersonDto;
import com.rogerhagerbaum.parkerning.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
@AllArgsConstructor
public class PersonController {
    private final PersonService personService;
    @PostMapping
    public ResponseEntity<PersonDto> addPerson(@RequestBody PersonDto personDto){
        return new ResponseEntity<>(personService.addPerson(personDto), HttpStatus.OK);
    }
}
