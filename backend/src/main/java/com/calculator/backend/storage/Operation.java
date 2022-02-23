package com.calculator.backend.storage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Operation {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String firstNumber;
    private String operatorSign;
    private String secondNumber;
    private String result;

    public Operation(String firstNumber, String operatorSign, String secondNumber, String result) {
        this.firstNumber = firstNumber;
        this.operatorSign = operatorSign;
        this.secondNumber = secondNumber;
        this.result = result;
    }
}
