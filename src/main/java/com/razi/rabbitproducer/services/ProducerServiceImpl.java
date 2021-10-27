package com.razi.rabbitproducer.services;

import com.razi.rabbitproducer.dto.MessageDto;
import com.razi.rabbitproducer.stream.MessageProducer;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class ProducerServiceImpl implements ProducerService{

    @Autowired
    private MessageProducer messageProducer;

    @Override
    public MessageDto sendMassage(MessageDto messageDto) {
        messageProducer.send(messageDto.getMessage());
        return messageDto;
    }
}
