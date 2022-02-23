package com.calculator.backend.util;

import com.calculator.backend.backend_for_frontend.dto.OperationDTO;
import com.calculator.backend.storage.Operation;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class OperationUtil {

    public static List<OperationDTO.HistoryResponse> operationsHistoryList = new ArrayList<>();

    public OperationDTO.Response getResponse(Operation operation) {
        return new OperationDTO.Response(operation.getId(), checkLastTwoCharacters(operation.getResult()));
    }

    public OperationDTO.HistoryResponse getHistoryResponse(Operation operation) {
        switch (operation.getOperatorSign()) {
            case "add":
                return new OperationDTO.HistoryResponse(
                        checkLastTwoCharacters(operation.getFirstNumber()),
                        "+",
                        checkLastTwoCharacters(operation.getSecondNumber()),
                        checkLastTwoCharacters(operation.getResult()));
            case "subtract":
                return new OperationDTO.HistoryResponse(
                        checkLastTwoCharacters(operation.getFirstNumber()),
                        "-",
                        checkLastTwoCharacters(operation.getSecondNumber()),
                        checkLastTwoCharacters(operation.getResult()));
            case "multiply":
                return new OperationDTO.HistoryResponse(
                        checkLastTwoCharacters(operation.getFirstNumber()),
                        "*",
                        checkLastTwoCharacters(operation.getSecondNumber()),
                        checkLastTwoCharacters(operation.getResult()));
            default:
                return new OperationDTO.HistoryResponse(
                        checkLastTwoCharacters(operation.getFirstNumber()),
                        "÷",
                        checkLastTwoCharacters(operation.getSecondNumber()),
                        checkLastTwoCharacters(operation.getResult()));
        }
    }

    private String checkLastTwoCharacters(String string) {
        if (string.endsWith(".0")) {
            return string.substring(0, string.length()-2);
        } else {
            return string;
        }
    }
}
