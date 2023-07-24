package com.springboot.app;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.AuditLog.AuditLogRepository;

@RestController
@RequestMapping("/api")
public class AuditLogController {

    @Autowired
    private AuditLogRepository auditLogRepository;

    @PostMapping("/audit")
    public ResponseEntity<String> logApiCall(@RequestBody AuditLogRepository request) {
        // Log the API call details to the database
        AuditLog log = new AuditLog();
        log.setApiEndpoint(request.getApiEndpoint());
        log.setRequestPayload(request.getRequestPayload());
        log.setResponsePayload(request.getResponsePayload());
        log.setUser(request.getUser());
        log.setRequestTime(LocalDateTime.now());

        auditLogRepository.save(log);

        return ResponseEntity.ok("API call logged successfully!");
    }

    @GetMapping("/audit")
    public ResponseEntity<List<AuditLog>> getAuditLogs() {
        // Retrieve all audit logs from the database
        List<AuditLog> auditLogs = auditLogRepository.findAll();
        return ResponseEntity.ok(auditLogs);
    }
}
