package edu.missouristate.csc615.chatbot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SystemStatusController {

    @Value("${spring.application.name:HR Chatbot API}")
    private String appName;

    @Value("${spring.profiles.active:local}")
    private String environment;

    @Value("${CHROMADB_URL:http://localhost:8000}")
    private String chromaUrl;

    @Value("${OLLAMA_BASE_URL:http://localhost:11434}")
    private String ollamaUrl;

    private final JdbcTemplate jdbcTemplate;
    private final RestTemplate restTemplate;

    public SystemStatusController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.restTemplate = createRestTemplate();
    }

    private RestTemplate createRestTemplate() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(3000);
        factory.setReadTimeout(3000);
        return new RestTemplate(factory);
    }

    @GetMapping("/")
    public Map<String, Object> status() {

        Map<String, Object> response = new HashMap<>();
        response.put("service", appName);
        response.put("status", "running");
        response.put("message", "API is up and healthy");
        response.put("timestamp", Instant.now());

        return response;
    }

    @GetMapping("/info")
    public Map<String, Object> info() {

        Map<String, Object> response = new HashMap<>();
        response.put("application", appName);
        response.put("environment", environment);
        response.put("timestamp", Instant.now());

        return response;
    }

    @GetMapping("/system")
    public Map<String, Object> systemStatus() {

        Map<String, Object> response = new HashMap<>();
        Map<String, String> services = new HashMap<>();

        response.put("application", appName);
        response.put("status", "UP");

        // Database check
        try {
            jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            services.put("database", "UP");
        } catch (Exception e) {
            services.put("database", "DOWN");
        }

        // ChromaDB check
        try {
            restTemplate.getForObject(chromaUrl + "/api/v2/heartbeat", String.class);
            services.put("chromadb", "UP");
        } catch (Exception e) {
            services.put("chromadb", "DOWN");
        }

        // Ollama check
        try {
            restTemplate.getForObject(ollamaUrl + "/api/tags", String.class);
            services.put("ollama", "UP");
        } catch (Exception e) {
            services.put("ollama", "DOWN");
        }

        response.put("services", services);
        response.put("timestamp", Instant.now());

        return response;
    }
}