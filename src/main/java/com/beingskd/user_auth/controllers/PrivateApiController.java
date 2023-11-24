package com.beingskd.user_auth.controllers;

import com.beingskd.user_auth.services.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/private-api")
public class PrivateApiController {

    @Autowired
    private PermissionService permissionService;

    @GetMapping("/secure")
    public ResponseEntity<String> secureEndpoint() {
        String permissionName = "WRITE_PRIVILEGE"; // Replace with your actual permission
        String username = "exampleUser"; // Replace with the authenticated user's username

        if (permissionService.hasPermission(username, permissionName)) {
            return ResponseEntity.ok("Access granted to secure endpoint!");
        } else {
            return ResponseEntity.status(403).body("Access denied to secure endpoint!");
        }
    }

}

