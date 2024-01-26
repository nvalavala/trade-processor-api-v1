package com.tradeprocessor.controller;

import com.tradeprocessor.message.Message;
import com.tradeprocessor.component.TradeProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private TradeProcessor tradeProcessor;

    @PostMapping("/processMessage")
    public ResponseEntity<String> processMessage(@RequestBody Message msg) {
        tradeProcessor.onMessage(msg);
        return ResponseEntity.ok("Message processed successfully");
    }
}
