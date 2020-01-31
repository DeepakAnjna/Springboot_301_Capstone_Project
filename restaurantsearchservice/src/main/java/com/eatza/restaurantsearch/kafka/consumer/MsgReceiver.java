package com.eatza.restaurantsearch.kafka.consumer;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class MsgReceiver {

	private static final Logger logger = LoggerFactory.getLogger(MsgReceiver.class);
	@Value(value = "${kafka-topic}")
    private String TOPIC;
	
	 
	@KafkaListener(topics = "test-topic", groupId = "kafka-test", containerFactory = "kafkaListenerContainerFactory")
	public void consume(@Payload MessageData messageData, @Headers MessageHeaders headers)throws IOException {
		logger.info("Consumed Message :" + messageData);
	}
}
