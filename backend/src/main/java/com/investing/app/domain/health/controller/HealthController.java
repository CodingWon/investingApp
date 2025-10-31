package com.investing.app.domain.health.controller;

import com.investing.app.domain.health.mapper.HealthMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class HealthController {

    private final HealthMapper healthMapper;

    @GetMapping("/")
    public ResponseEntity<Map<String, String>> root() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "InvestingApp API");
        response.put("version", "1.0.0");
        response.put("description", "Spring Boot + JPA + MyBatis");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> healthCheck() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "healthy");
        return ResponseEntity.ok(response);
    }

    /**
     * MyBatis를 사용한 데이터베이스 연결 테스트
     */
    @GetMapping("/health/db")
    public ResponseEntity<Map<String, Object>> databaseCheck() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "connected");
        response.put("database", healthMapper.checkDatabase());
        return ResponseEntity.ok(response);
    }

    /**
     * MyBatis XML 매퍼 테스트
     */
    @GetMapping("/health/db/version")
    public ResponseEntity<Map<String, Object>> databaseVersion() {
        return ResponseEntity.ok(healthMapper.getVersion());
    }
}
