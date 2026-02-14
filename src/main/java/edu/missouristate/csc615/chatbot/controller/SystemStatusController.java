package edu.missouristate.csc615.chatbot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SystemStatusController {

    @GetMapping("/")
    public Map<String, Object> systemStatus() {
        Map<String, Object> response = new HashMap<>();
        response.put("service", "HR Chatbot API");
        response.put("status", "running");
        response.put("version", "1.0");
        return response;
    }
}