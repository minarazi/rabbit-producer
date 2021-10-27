package com.razi.rabbitproducer.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class MessageDto {

    @NotNull(message = "message is required")
    private String message;

}
