package com.calculator.backend.backend_for_frontend.controller;

import com.calculator.backend.backend_for_frontend.dto.OperationDTO;
import com.calculator.backend.service.OperationService;
import com.calculator.backend.storage.Operation;
import com.calculator.backend.util.OperationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class OperationController {

    private final OperationService operationService;

    @Autowired
    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }

    @GetMapping
    public List<OperationDTO.HistoryResponse> getResponseList() {
        return OperationUtil.operationsHistoryList;
    }

    @GetMapping("/delete_history")
    public List<?> getEmptyResponseList() {
        OperationUtil.operationsHistoryList = new ArrayList<>();
        return OperationUtil.operationsHistoryList;
    }

    @PostMapping("/add")
    public OperationDTO.Response add(@RequestBody OperationDTO.ValuesAndOperator valuesAndOperatorDTO) {
        return operationService.add(valuesAndOperatorDTO.getFirstNumber(), "add",
                valuesAndOperatorDTO.getSecondNumber());
    }

    @PostMapping("/subtract")
    public OperationDTO.Response subtract(@RequestBody OperationDTO.ValuesAndOperator valuesAndOperatorDTO) {
        return operationService.subtract(valuesAndOperatorDTO.getFirstNumber(), "subtract",
                valuesAndOperatorDTO.getSecondNumber());
    }

    @PostMapping("/multiply")
    public OperationDTO.Response multiply(@RequestBody OperationDTO.ValuesAndOperator valuesAndOperatorDTO) {
        System.out.println(valuesAndOperatorDTO.getFirstNumber());
        return operationService.multiply(valuesAndOperatorDTO.getFirstNumber(), "multiply",
                valuesAndOperatorDTO.getSecondNumber());
    }

    @PostMapping("/divide")
    public OperationDTO.Response divide(@RequestBody OperationDTO.ValuesAndOperator valuesAndOperatorDTO) {
        return operationService.divide(valuesAndOperatorDTO.getFirstNumber(), "divide",
                valuesAndOperatorDTO.getSecondNumber());
    }
}
