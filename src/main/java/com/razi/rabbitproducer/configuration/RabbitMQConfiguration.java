package com.razi.rabbitproducer.configuration;

import com.razi.rabbitproducer.stream.MessageProducer;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    @Value("${rabbitmq.message.queue.name}")
    private String messageQueueName;

    @Bean
    public Queue messageQueue() {
        return new Queue(messageQueueName);
    }

    @Bean
    public MessageProducer messageProducer() {
        return new MessageProducer();
    }
}
