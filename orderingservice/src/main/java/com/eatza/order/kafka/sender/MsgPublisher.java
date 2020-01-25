package com.eatza.order.kafka.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MsgPublisher {
	
	   @Autowired
	    private KafkaTemplate<String, String> kafkaTemplate;
	   
	   @Value(value = "${kafka-topic}")
	    private String topic;
	   
	   private final Logger logger = LoggerFactory.getLogger(MsgPublisher.class);

	   
	    public void sendMessage(String message) {
	    	logger.info("sending message='{}' to topic='{}'", message, topic);
	        this.kafkaTemplate.send(topic, message);
	    }
}
