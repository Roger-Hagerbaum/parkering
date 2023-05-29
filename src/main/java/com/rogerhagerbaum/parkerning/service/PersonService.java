package com.rogerhagerbaum.parkerning.service;

import com.rogerhagerbaum.parkerning.module.dto.PersonDto;
import com.rogerhagerbaum.parkerning.module.entity.Person;
import com.rogerhagerbaum.parkerning.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class PersonService {
    ModelMapper modelMapper;
    PersonRepository personRepository;
    public PersonDto addPerson(PersonDto personDto) {
        Person createNew = modelMapper.map(personDto, Person.class);
        personRepository.save(createNew);

        return modelMapper.map(createNew, PersonDto.class);
    }
}
