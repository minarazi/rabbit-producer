package com.razi.rabbitproducer.stream;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@Log4j2
public class MessageProducer {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    public void send(String message) {
        this.template.convertAndSend(queue.getName(), message);
        log.info("Sent: '{}", message);
    }
}
