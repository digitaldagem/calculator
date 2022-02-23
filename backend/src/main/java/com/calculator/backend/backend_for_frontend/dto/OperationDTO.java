package com.calculator.backend.backend_for_frontend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

public class OperationDTO {

    @Value
    public static class ValuesAndOperator {
        double firstNumber;
        String operatorSign;
        double secondNumber;

        public ValuesAndOperator(@JsonProperty("firstValue") double firstNumber,
                                 @JsonProperty("operatorSign") String operatorSign,
                                 @JsonProperty("secondValue") double secondNumber) {
            this.firstNumber = firstNumber;
            this.operatorSign = operatorSign;
            this.secondNumber = secondNumber;
        }
    }

    @Value
    public static class Response {
        String id;
        String result;
    }

    @Value
    public static class HistoryResponse {
        String firstValue;
        String operatorSign;
        String secondValue;
        String result;
    }
}
