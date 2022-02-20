package com.calculator.backend.backend_for_frontend.dto;

import lombok.Value;

public class OperationDTO {

    @Value
    public static class ValuesAndOperator {
        double firstValue;
        String operator;
        double secondValue;
    }

    @Value
    public static class Response {
        String id;
        double result;
    }
}
