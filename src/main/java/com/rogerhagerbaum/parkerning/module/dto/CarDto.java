package com.rogerhagerbaum.parkerning.module.dto;

import com.rogerhagerbaum.parkerning.module.entity.Car;
import com.rogerhagerbaum.parkerning.module.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarDto {
    private Long id;
    private String registration;
    private Person person;
    private Long person_id;

    public CarDto(Car c){
        this.id = c.getId();
        this.registration = c.getRegistration();
        this.person = c.getPerson();
        this.person_id = c.getPerson().getId();
    }

}
