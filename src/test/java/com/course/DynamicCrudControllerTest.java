package com.course;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DynamicCrudControllerTest {

    @LocalServerPort
    private int port;

    private final TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void testCrudOperations() {
        // Assuming the API is running at http://localhost:${port}/api/{tableName}

        // Create
        String tableName = "student";
        Map<String, Object> recordToCreate = new HashMap<>();
        // Populate your record with data
        recordToCreate.put("name", "John Doe");
        recordToCreate.put("age", 25);
        recordToCreate.put("grade", "A");
        recordToCreate.put("department", "Computer Science");
        

        
        Map<String, Object> createdRecord = restTemplate.postForObject(
                "http://localhost:" + port + "/api/" + tableName,
                recordToCreate,
                Map.class
        );

        // Read
        Map<String, Object> readRecord = restTemplate.getForObject(
                "http://localhost:" + port + "/api/" + tableName + "/" + createdRecord.get("id"),
                Map.class
        );
        assertThat(readRecord).isEqualTo(createdRecord);

        // Update
        Map<String, Object> updatedRecord = new HashMap<>();
        // Populate your updated record with data
        recordToCreate.put("name", "John Doe");
        recordToCreate.put("age", 25);
        recordToCreate.put("grade", "A");
        recordToCreate.put("department", "Computer Science");
        //we can add the data in this 
        
        
        restTemplate.put(
                "http://localhost:" + port + "/api/" + tableName + "/" + createdRecord.get("id"),
                updatedRecord
        );
        Map<String, Object> afterUpdateRecord = restTemplate.getForObject(
                "http://localhost:" + port + "/api/" + tableName + "/" + createdRecord.get("id"),
                Map.class
        );
        assertThat(afterUpdateRecord).isEqualTo(updatedRecord);

        // Delete
        restTemplate.delete("http://localhost:" + port + "/api/" + tableName + "/" + createdRecord.get("id"));
        Map<String, Object> afterDeleteRecord = restTemplate.getForObject(
                "http://localhost:" + port + "/api/" + tableName + "/" + createdRecord.get("id"),
                Map.class
        );
        assertThat(afterDeleteRecord).isNull();
    }
}

