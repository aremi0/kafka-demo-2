package com.example.kafkademo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
    private final Producer producer;

    @Autowired
    public ProducerController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping("/publish")
    public void messageToTopic(@RequestBody String message) {
        try{
            this.producer.sendMessage(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
