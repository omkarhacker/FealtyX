package com.edigest.journalApp.service;

import com.edigest.journalApp.model.Student;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OllamaService {
    private static final String OLLAMA_API_URL = "http://localhost:11434/api/generate";
    private final RestTemplate restTemplate = new RestTemplate();

    public String generateStudentSummary(Student student) {
    String prompt = String.format(
        "Generate a 1-2 sentence summary for %s (age %d). Focus on potential and traits. Be concise.",
        student.getName(), student.getAge()
    );

    String requestBody = String.format(
        "{\"model\": \"mistral:instruct\", \"prompt\": \"%s\", \"stream\": false}", prompt
    );

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

    try {
        ResponseEntity<String> response = restTemplate.exchange(
            OLLAMA_API_URL, HttpMethod.POST, entity, String.class
        );
        
        // Parse ONLY the "response" field from JSON
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        return root.path("response").asText(); // Returns just the summary string

    } catch (Exception e) {
        return "Error generating summary: " + e.getMessage();
    }
}
}