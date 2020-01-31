package com.eatza.order.kafka.sender;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class MsgPublisher {
	
	   
	   private final Logger logger = LoggerFactory.getLogger(MsgPublisher.class);

	   @Autowired
	   private KafkaTemplate<String, MessageData> kafkaTemplate;
	   
	   @Value(value = "${kafka-topic}")
	    private String TOPIC;
		

		  public void send(MessageData msg) {
			
			  logger.info(String.format("\n ===== Producing message in JSON ===== \n"+msg));
			    Message<MessageData> message = MessageBuilder
			            .withPayload(msg)
			            .setHeader(KafkaHeaders.TOPIC, TOPIC)
			            .build();
			    this.kafkaTemplate.send(message);
		  }
}
