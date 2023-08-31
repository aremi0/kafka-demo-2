package com.example.kafkademo2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "test_topic", groupId = "group_id")
    public void consumeMessage(String message) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(message);
        logger.info("Json message received using kafka listener: " + jsonString);
    }
}
