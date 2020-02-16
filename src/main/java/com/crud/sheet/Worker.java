package com.crud.sheet;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@RequiredArgsConstructor
@Entity
public class Worker {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id;
    String name;
    String salary;
    String department;
}
