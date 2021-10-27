package com.razi.rabbitproducer.api;

import com.razi.rabbitproducer.dto.MessageDto;
import com.razi.rabbitproducer.services.ProducerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.support.MethodArgumentNotValidException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Log4j2
@RestController
@RequestMapping("/api/producer")
public class ProducerResource {

    private final ProducerService producerService;

    public ProducerResource(ProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/put-messages")
    private ResponseEntity<Void> putMassage (@Valid @RequestBody MessageDto messageDto){
        producerService.sendMassage(messageDto);

        log.info("massages added, {}", messageDto);

        return ResponseEntity.ok().build();
    }
//
//    @ResponseStatus(HttpStatus.CONFLICT)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String, String> handleValidationExceptions(
//            MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        return errors;
//    }
}
