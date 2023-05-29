package com.rogerhagerbaum.parkerning.module.dto;

import com.rogerhagerbaum.parkerning.module.entity.Car;
import com.rogerhagerbaum.parkerning.module.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonDto {
    private Long id;
    private String name;
    private List<Car> cars;

    public PersonDto(Person p){
        this.id = p.getId();
        this.name = p.getName();
        this.cars = p.getCars();
    }
}
