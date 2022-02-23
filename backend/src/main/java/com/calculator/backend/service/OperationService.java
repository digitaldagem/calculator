package com.calculator.backend.service;

import com.calculator.backend.backend_for_frontend.dto.OperationDTO;
import com.calculator.backend.storage.Operation;
import com.calculator.backend.storage.OperationRepository;
import com.calculator.backend.util.OperationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationService {

    private final OperationRepository operationRepository;

    @Autowired
    public OperationService(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    public OperationDTO.Response add(double firstValue, String operator, double secondValue) {
        Operation operation = checkAndRetrieveOperationIfContained(firstValue, operator, secondValue);
        if (operation == null) {
            double result = firstValue + secondValue;
            return persistOperationAndGetResponseDTO(firstValue, operator, secondValue, result);
        } else {
            OperationUtil.operationsHistoryList.add(OperationUtil.getHistoryResponse(operation));
            return OperationUtil.getResponse(operation);
        }
    }

    public OperationDTO.Response subtract(double firstValue, String operator, double secondValue) {
        Operation operation = checkAndRetrieveOperationIfContained(firstValue, operator, secondValue);
        if (operation == null) {
            double result = firstValue - secondValue;
            return persistOperationAndGetResponseDTO(firstValue, operator, secondValue, result);
        } else {
            OperationUtil.operationsHistoryList.add(OperationUtil.getHistoryResponse(operation));
            return OperationUtil.getResponse(operation);
        }
    }

    public OperationDTO.Response multiply(double firstValue, String operator, double secondValue) {
        Operation operation = checkAndRetrieveOperationIfContained(firstValue, operator, secondValue);
        if (operation == null) {
            double result = firstValue * secondValue;
            return persistOperationAndGetResponseDTO(firstValue, operator, secondValue, result);
        } else {
            OperationUtil.operationsHistoryList.add(OperationUtil.getHistoryResponse(operation));
            return OperationUtil.getResponse(operation);
        }
    }

    public OperationDTO.Response divide(double firstValue, String operator, double secondValue) {
        Operation operation = checkAndRetrieveOperationIfContained(firstValue, operator, secondValue);
        if (operation == null) {
            double result = firstValue / secondValue;
            return persistOperationAndGetResponseDTO(firstValue, operator, secondValue, result);
        } else {
            OperationUtil.operationsHistoryList.add(OperationUtil.getHistoryResponse(operation));
            return OperationUtil.getResponse(operation);
        }
    }

    private Operation checkAndRetrieveOperationIfContained(double firstValue, String operator, double secondValue) {
        return operationRepository.findAll().stream()
                .filter(operation ->
                        operation.getFirstNumber().equals(String.valueOf(firstValue))
                                && operation.getOperatorSign().equals(operator)
                                && operation.getSecondNumber().equals(String.valueOf(secondValue)))
                .findFirst()
                .orElse(null);
    }

    private OperationDTO.Response persistOperationAndGetResponseDTO(double firstValue, String operator, double secondValue, double result) {
        System.out.println(result);
        Operation operation = operationRepository.save(
                new Operation(
                        String.valueOf(firstValue),
                        operator,
                        String.valueOf(secondValue),
                        String.valueOf(result)));
        OperationUtil.operationsHistoryList.add(OperationUtil.getHistoryResponse(operation));
        return OperationUtil.getResponse(operation);
    }
}
