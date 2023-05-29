package com.rogerhagerbaum.parkerning.service;

import com.rogerhagerbaum.parkerning.module.dto.CarDto;
import com.rogerhagerbaum.parkerning.module.dto.PersonDto;
import com.rogerhagerbaum.parkerning.module.entity.Car;
import com.rogerhagerbaum.parkerning.module.entity.Person;
import com.rogerhagerbaum.parkerning.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    public List<PersonDto> getAll(){
        Set<Person> persons;
            persons = personRepository.getAll();
        return persons.stream()
                .map(PersonDto::new)
                .collect(Collectors.toList());
    }
    public PersonDto getById(int id){
        Person person = personRepository.findPersonById(id);
        return modelMapper.map(person , PersonDto.class);
    }
    public PersonDto deletePerson(int id) {
        Person person = personRepository.findPersonById(id);
        personRepository.delete(person);
        return modelMapper.map(person, PersonDto.class);
    }
}
