package com.strconsumer.consumer.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
public class StrConsumerListener {
	
	private static Logger logger = LoggerFactory.getLogger(StrConsumerListener.class);
	
	@KafkaListener(groupId = "group-1", 
			topicPartitions = {
					@TopicPartition(topic = "str-topic", partitions = {"0"})
			}
			, containerFactory = "strContainerFactory")
	public void create(String message) {
		logger.info("CREATE ::: Receive message {}", message);
	}
	
	@KafkaListener(groupId = "group-1", 
			topicPartitions = {
					@TopicPartition(topic = "str-topic", partitions = {"1"})
			}
			, containerFactory = "strContainerFactory")
	public void log(String message) {
		logger.info("LOG ::: Receive message {}", message);
	}
	
	@KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "strContainerFactory")
	public void history(String message) {
		logger.info("HISTORY ::: Receive message {}", message);
	}
}
