package com.razi.rabbitproducer.services;

import com.razi.rabbitproducer.dto.MessageDto;

public interface ProducerService {

    MessageDto sendMassage(MessageDto messageDto);

}
