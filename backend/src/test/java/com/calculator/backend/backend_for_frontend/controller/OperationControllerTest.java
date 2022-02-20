package com.calculator.backend.backend_for_frontend.controller;

import com.calculator.backend.storage.Operation;
import com.calculator.backend.util.OperationUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class OperationControllerTest {

    @Autowired
    TestRestTemplate restTemplate;
    @LocalServerPort
    int randomServerPort;

    static URI uri;

    @BeforeEach
    void setUp() throws URISyntaxException {
        final String baseUrl = "http://localhost:"+randomServerPort+"/delete_history";
        uri = new URI(baseUrl);
    }

    @Test
    void deletesAllOperationsInHistoryList() {
        // given
        Operation operationOne = new Operation(UUID.randomUUID().toString(), 1.0, "+", 1.0, 2.0);
        OperationUtil.operationsHistoryList.add(operationOne);
        OperationUtil.operationsHistoryList.add(operationOne);
        List<Operation> operationsHistoryListBeforeDeletionCall = OperationUtil.operationsHistoryList;

        // when
        this.restTemplate.getForEntity(uri, List.class);

        // then
        assertEquals(operationsHistoryListBeforeDeletionCall.size(), 2);
        assertEquals(OperationUtil.operationsHistoryList.size(), 0);
    }
}
