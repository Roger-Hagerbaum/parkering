package com.rogerhagerbaum.parkerning.module.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;

    @OneToMany(mappedBy = "person")
    private List<Car> cars;
}
