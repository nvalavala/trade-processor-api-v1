package com.tradeprocessor.processor;

import com.tradeprocessor.component.TradeProcessor;
import com.tradeprocessor.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @Autowired
    private TradeProcessor tradeProcessor;

    @KafkaListener(topics = "SCOTIA-APP-001")
    public void onMessage(Message msg) {
        tradeProcessor.onMessage(msg);
    }
}

