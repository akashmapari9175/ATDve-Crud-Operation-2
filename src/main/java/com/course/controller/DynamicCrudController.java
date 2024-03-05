package com.course.controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/{tableName}")
public class DynamicCrudController {

    private final Map<String, Map<Long, Map<String, Object>>> database = new HashMap<>();

    // CREATE
    @PostMapping
    public Map<String, Object> createRecord(@PathVariable String tableName, @RequestBody Map<String, Object> record) {
        database.computeIfAbsent(tableName, k -> new HashMap<>());
        long id = System.currentTimeMillis(); // Generate a unique ID
        record.put("id", id);
        database.get(tableName).put(id, record);
        return record;
    }

    // READ
    @GetMapping("/{id}")
    public Map<String, Object> getRecordById(@PathVariable String tableName, @PathVariable long id) {
        return database.getOrDefault(tableName, new HashMap<>()).get(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Map<String, Object> updateRecord(@PathVariable String tableName, @PathVariable long id, @RequestBody Map<String, Object> updatedRecord) {
        Map<String, Object> record = database.getOrDefault(tableName, new HashMap<>()).get(id);
        if (record != null) {
            record.putAll(updatedRecord);
        }
        return record;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteRecord(@PathVariable String tableName, @PathVariable long id) {
        database.getOrDefault(tableName, new HashMap<>()).remove(id);
    }
}
