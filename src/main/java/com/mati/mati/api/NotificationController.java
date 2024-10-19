package com.mati.mati.api;

import com.mati.mati.model.NotificationRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/api")
public class NotificationController {

    @PostMapping(path = "/notify", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> notifyClient(@RequestBody NotificationRequest request) {
        return ResponseEntity.ok().build();
    }
}
