package org.iit.factorypattern.controller;

import org.iit.factorypattern.AlertService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notify")
public class NotificationController {

    private final AlertService alertService;

    public NotificationController(AlertService alertService) {
        this.alertService = alertService;
    }

    @PostMapping
    public ResponseEntity<String> notify(
            @RequestParam String channel,
            @RequestParam String message) {

        alertService.sendAlert(channel, message);
        return ResponseEntity.ok("Notification sent via " + channel);
    }
}
