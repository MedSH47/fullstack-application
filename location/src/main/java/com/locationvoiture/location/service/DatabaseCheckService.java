package com.locationvoiture.location.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DatabaseCheckService {
     @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean isDatabaseConnected() {
        try {
            
            jdbcTemplate.execute("SELECT 1");
            return true;
        } catch (Exception e) {
            
            return false;
        }
    }
}
