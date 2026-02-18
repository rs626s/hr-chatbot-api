package edu.missouristate.csc615.chatbot.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthResponse {
    // Getters and setters
    private String token;
    private String type;
    private Long id;
    private String username;
    private String email;
    private String role;

    public AuthResponse(String token, String type, Long id,
                        String username, String email, String role) {
        this.token = token;
        this.type = type;
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = role;
    }
}