package com.calculator.backend.service;

import com.calculator.backend.backend_for_frontend.dto.OperationDTO;
import com.calculator.backend.storage.Operation;
import com.calculator.backend.storage.OperationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@TestPropertySource(
        locations = "classpath:application-test.properties")
class OperationServiceTest {

    @Autowired
    TestEntityManager testEntityManager;
    @Autowired
    OperationRepository operationRepository;

    static OperationService operationService;

    @BeforeEach
    void setUp() {
        operationService = new OperationService(operationRepository);
    }

    @Test
    void add_returnsResultFromExistingObject() {
        // given
        Operation operation = new Operation(
                UUID.randomUUID().toString(), 1.0, "+", 1.0, 2.0);
        testEntityManager.persist(operation);
        List<Operation> operations = operationRepository.findAll();

        // when
        OperationDTO.ValuesAndOperator valuesAndOperatorDTO = new OperationDTO.ValuesAndOperator(
                1.0, "+", 1.0);
        OperationDTO.Response response = operationService.add(valuesAndOperatorDTO);

        // then
        assertEquals(1, operations.size());
        assertEquals(operationRepository.findAll().get(0).getResult(), response.getResult());
    }

    @Test
    void add_returnsResultAfterCreatingNewObject() {
        // given
        List<Operation> operations = operationRepository.findAll();

        // when
        OperationDTO.ValuesAndOperator valuesAndOperatorDTO = new OperationDTO.ValuesAndOperator(
                1.0, "+", 1.0);
        OperationDTO.Response response = operationService.add(valuesAndOperatorDTO);

        // then
        assertEquals(0, operations.size());
        assertEquals(operationRepository.findAll().get(0).getResult(), response.getResult());
    }

    @Test
    void subtract_returnsResultFromExistingObject() {
        // given
        Operation operation = new Operation(
                UUID.randomUUID().toString(), 1.0, "-", 1.0, 0.0);
        testEntityManager.persist(operation);
        List<Operation> operations = operationRepository.findAll();

        // when
        OperationDTO.ValuesAndOperator valuesAndOperatorDTO = new OperationDTO.ValuesAndOperator(
                1.0, "-", 1.0);
        OperationDTO.Response response = operationService.subtract(valuesAndOperatorDTO);

        // then
        assertEquals(1, operations.size());
        assertEquals(operationRepository.findAll().get(0).getResult(), response.getResult());
    }

    @Test
    void subtract_returnsResultAfterCreatingNewObject() {
        // given
        List<Operation> operations = operationRepository.findAll();

        // when
        OperationDTO.ValuesAndOperator valuesAndOperatorDTO = new OperationDTO.ValuesAndOperator(
                1.0, "-", 1.0);
        OperationDTO.Response response = operationService.subtract(valuesAndOperatorDTO);

        // then
        assertEquals(0, operations.size());
        assertEquals(operationRepository.findAll().get(0).getResult(), response.getResult());
    }

    @Test
    void multiply_returnsResultFromExistingObject() {
        // given
        Operation operation = new Operation(
                UUID.randomUUID().toString(), 1.0, "x", 1.0, 1.0);
        testEntityManager.persist(operation);
        List<Operation> operations = operationRepository.findAll();

        // when
        OperationDTO.ValuesAndOperator valuesAndOperatorDTO = new OperationDTO.ValuesAndOperator(
                1.0, "*", 1.0);
        OperationDTO.Response response = operationService.multiply(valuesAndOperatorDTO);

        // then
        assertEquals(1, operations.size());
        assertEquals(operationRepository.findAll().get(0).getResult(), response.getResult());
    }

    @Test
    void multiply_returnsResultAfterCreatingNewObject() {
        // given
        List<Operation> operations = operationRepository.findAll();

        // when
        OperationDTO.ValuesAndOperator valuesAndOperatorDTO = new OperationDTO.ValuesAndOperator(
                1.0, "*", 1.0);
        OperationDTO.Response response = operationService.multiply(valuesAndOperatorDTO);

        // then
        assertEquals(0, operations.size());
        assertEquals(operationRepository.findAll().get(0).getResult(), response.getResult());
    }

    @Test
    void divide_returnsResultFromExistingObject() {
        // given
        Operation operation = new Operation(
                UUID.randomUUID().toString(), 2.0, "÷", 2.0, 1.0);
        testEntityManager.persist(operation);
        List<Operation> operations = operationRepository.findAll();

        // when
        OperationDTO.ValuesAndOperator valuesAndOperatorDTO = new OperationDTO.ValuesAndOperator(
                2.0, "÷", 2.0);
        OperationDTO.Response response = operationService.divide(valuesAndOperatorDTO);

        // then
        assertEquals(1, operations.size());
        assertEquals(operationRepository.findAll().get(0).getResult(), response.getResult());
    }

    @Test
    void divide_returnsResultAfterCreatingNewObject() {
        // given
        List<Operation> operations = operationRepository.findAll();

        // when
        OperationDTO.ValuesAndOperator valuesAndOperatorDTO = new OperationDTO.ValuesAndOperator(
                2.0, "÷", 2.0);
        OperationDTO.Response response = operationService.divide(valuesAndOperatorDTO);

        // then
        assertEquals(0, operations.size());
        assertEquals(operationRepository.findAll().get(0).getResult(), response.getResult());
    }
}
