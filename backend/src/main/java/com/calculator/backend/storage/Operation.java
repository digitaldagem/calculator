package com.calculator.backend.storage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Operation {
    @Id
    private String id;
    private double firstValue;
    private String operator;
    private double secondValue;
    private double result;
}
