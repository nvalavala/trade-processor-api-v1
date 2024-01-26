package com.tradeprocessor.tradeprocessorapi;

import com.tradeprocessor.component.TradeProcessor;
import com.tradeprocessor.message.Message;
import com.tradeprocessor.processor.MessageListener;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.kafka.test.context.EmbeddedKafka;

@SpringBootTest
@EmbeddedKafka(partitions = 1, brokerProperties = {"listeners=PLAINTEXT://localhost:9092", "port=9092"})
public class MessageListenerTest {

    @Autowired
    private MessageListener messageListener;

    @MockBean
    private TradeProcessor tradeProcessor;

    @Test
    public void testOnMessage() {

        // Trigger the onMessage method manually (simulating Kafka message consumption)
        Message mockMessage = new Message();
        messageListener.onMessage(mockMessage);

        // Verify that the onMessage method of TradeProcessor was called as expected
        Mockito.verify(tradeProcessor, Mockito.times(1)).onMessage(mockMessage);
    }
}
