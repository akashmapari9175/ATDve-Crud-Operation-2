package com.course.test;

import java.util.HashMap;
import java.util.Map;

public class DynamicCRUD {

    private Map<String, Map<String, Object>> tableData;

    public DynamicCRUD() {
        this.tableData = new HashMap<>();
    }

    // Create operation
    public void createRecord(String tableName, Map<String, Object> record) {
        tableData.put(tableName, record);
    }

    // Read operation
    public Map<String, Object> readRecord(String tableName) {
        return tableData.get(tableName);
    }

    // Update operation
    public void updateRecord(String tableName, String columnName, Object newValue) {
        if (tableData.containsKey(tableName)) {
            Map<String, Object> record = tableData.get(tableName);
            record.put(columnName, newValue);
        }
    }

    // Delete operation
    public void deleteRecord(String tableName) {
        tableData.remove(tableName);
    }
}
