package com.technophile.service;

import com.technophile.dto.Customer;
import com.technophile.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {
    @Autowired
    private KafkaTemplate<String,Object> template;
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${app.topic.name}")
    private String topicName;



    public void sendEvents(User user) {
        try {
            CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topicName, user);
            future.whenComplete((result, ex) -> {
                if (ex == null) {
                    System.out.println("Sent message=[" + user.toString() +
                            "] with offset=[" + result.getRecordMetadata().offset() + "]");
                } else {
                    System.out.println("Unable to send message=[" +
                            user.toString() + "] due to : " + ex.getMessage());
                }
            });
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void sendMessageToTopic(String message){
        CompletableFuture<SendResult<String, Object>> future = template.send("sunday", message);
        /**
         * pushing message into specific partition
         */
        //CompletableFuture<SendResult<String, Object>> future = template.send("sunday",0,null, message);
        future.whenComplete((result,ex)->{
            if (ex == null) {
                System.out.println("Sent message=[" + message +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" +
                        message + "] due to : " + ex.getMessage());
            }
        });
    }

    public void sendEventsToTopic(Customer customer) {
        try {
            CompletableFuture<SendResult<String, Object>> future = template.send("java-demo", customer);
            future.whenComplete((result, ex) -> {
                if (ex == null) {
                    System.out.println("Sent message=[" + customer +
                            "] with offset=[" + result.getRecordMetadata().offset() + "]");
                } else {
                    System.out.println("Unable to send message=[" +
                            customer + "] due to : " + ex.getMessage());
                }
            });
        } catch (Exception e) {
            System.out.println("ERROR : "+e.getMessage());
        }
    }
}
