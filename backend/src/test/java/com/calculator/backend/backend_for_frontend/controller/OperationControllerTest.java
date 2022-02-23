package com.calculator.backend.backend_for_frontend.controller;

import com.calculator.backend.backend_for_frontend.dto.OperationDTO;
import com.calculator.backend.storage.Operation;
import com.calculator.backend.util.OperationUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class OperationControllerTest {

    @Autowired
    TestRestTemplate restTemplate;
    @LocalServerPort
    int randomServerPort;

    @BeforeEach
    void setUp() {
        Operation operation = new Operation("1.0", "add", "1.0", "2.0");
        OperationUtil.operationsHistoryList = new ArrayList<>();
        OperationUtil.operationsHistoryList.add(OperationUtil.getHistoryResponse(operation));
        OperationUtil.operationsHistoryList.add(OperationUtil.getHistoryResponse(operation));
    }

    @Test
    void getsOperationsHistoryList() {
        // when
        this.restTemplate.getForEntity("http://localhost:"+randomServerPort+"/", List.class);

        // then
        assertEquals(2, OperationUtil.operationsHistoryList.size());
    }

    @Test
    void deletesAllOperationsInHistoryList() {
        // given
        List<OperationDTO.HistoryResponse> operationsHistoryListBeforeDeletionCall = OperationUtil.operationsHistoryList;

        // when
        this.restTemplate.getForEntity("http://localhost:"+randomServerPort+"/delete_history", List.class);

        // then
        assertEquals(2, operationsHistoryListBeforeDeletionCall.size());
        assertEquals(0, OperationUtil.operationsHistoryList.size());
    }
}
