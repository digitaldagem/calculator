package com.calculator.backend.util;

import com.calculator.backend.backend_for_frontend.dto.OperationDTO;
import com.calculator.backend.storage.Operation;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class OperationUtil {

    public static List<Operation> operationsHistoryList = new ArrayList<>();

    public OperationDTO.ValuesAndOperator getValuesAndOperator(Operation operation) {
        return new OperationDTO.ValuesAndOperator(
                operation.getFirstValue(), operation.getOperator(), operation.getSecondValue());
    }

    public OperationDTO.Response getResponse(Operation operation) {
        return new OperationDTO.Response(operation.getId(), operation.getResult());
    }
}
