package com.tradeprocessor.service;

public interface KafkaTemplate<String, TradeMessage> {
	/**
	* Sends TradeMessage to default Kafka topic.
	*/
	void sendDefault(String key, TradeMessage msg);
}
