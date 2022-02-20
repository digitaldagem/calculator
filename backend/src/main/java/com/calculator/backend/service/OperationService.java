package com.calculator.backend.service;

import com.calculator.backend.backend_for_frontend.dto.OperationDTO;
import com.calculator.backend.storage.Operation;
import com.calculator.backend.storage.OperationRepository;
import com.calculator.backend.util.OperationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OperationService {

    private final OperationRepository operationRepository;

    @Autowired
    public OperationService(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    public OperationDTO.Response add(OperationDTO.ValuesAndOperator valuesAndOperatorDTO) {
        Operation operation = checkAndRetrieveOperationIfContained(valuesAndOperatorDTO);
        if (operation == null) {
            double result = valuesAndOperatorDTO.getFirstValue() + valuesAndOperatorDTO.getSecondValue();
            return persistOperationAndGetResponseDTO(valuesAndOperatorDTO, result);
        } else {
            OperationUtil.operationsHistoryList.add(operation);
            return OperationUtil.getResponse(operation);
        }
    }

    public OperationDTO.Response subtract(OperationDTO.ValuesAndOperator valuesAndOperatorDTO) {
        Operation operation = checkAndRetrieveOperationIfContained(valuesAndOperatorDTO);
        if (operation == null) {
            double result = valuesAndOperatorDTO.getFirstValue() - valuesAndOperatorDTO.getSecondValue();
            return persistOperationAndGetResponseDTO(valuesAndOperatorDTO, result);
        } else {
            OperationUtil.operationsHistoryList.add(operation);
            return OperationUtil.getResponse(operation);
        }
    }

    public OperationDTO.Response multiply(OperationDTO.ValuesAndOperator valuesAndOperatorDTO) {
        Operation operation = checkAndRetrieveOperationIfContained(valuesAndOperatorDTO);
        if (operation == null) {
            double result = valuesAndOperatorDTO.getFirstValue() * valuesAndOperatorDTO.getSecondValue();
            return persistOperationAndGetResponseDTO(valuesAndOperatorDTO, result);
        } else {
            OperationUtil.operationsHistoryList.add(operation);
            return OperationUtil.getResponse(operation);
        }
    }

    public OperationDTO.Response divide(OperationDTO.ValuesAndOperator valuesAndOperatorDTO) {
        Operation operation = checkAndRetrieveOperationIfContained(valuesAndOperatorDTO);
        if (operation == null) {
            double result = valuesAndOperatorDTO.getFirstValue() / valuesAndOperatorDTO.getSecondValue();
            return persistOperationAndGetResponseDTO(valuesAndOperatorDTO, result);
        } else {
            OperationUtil.operationsHistoryList.add(operation);
            return OperationUtil.getResponse(operation);
        }
    }

    private Operation checkAndRetrieveOperationIfContained(OperationDTO.ValuesAndOperator valuesAndOperatorDTO) {
        return operationRepository.findAll().stream()
                .filter(operation -> OperationUtil.getValuesAndOperator(operation).equals(valuesAndOperatorDTO))
                .findFirst()
                .orElse(null);
    }

    private OperationDTO.Response persistOperationAndGetResponseDTO(OperationDTO.ValuesAndOperator valuesAndOperatorDTO, double result) {
        Operation operation = operationRepository.save(
                new Operation(
                        UUID.randomUUID().toString(),
                        valuesAndOperatorDTO.getFirstValue(),
                        valuesAndOperatorDTO.getOperator(),
                        valuesAndOperatorDTO.getSecondValue(),
                        result));
        OperationUtil.operationsHistoryList.add(operation);
        return OperationUtil.getResponse(operation);
    }
}
