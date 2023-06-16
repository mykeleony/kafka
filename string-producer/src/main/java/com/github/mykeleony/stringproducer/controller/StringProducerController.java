package com.github.mykeleony.stringproducer.controller;

import com.github.mykeleony.stringproducer.service.StringProducerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer")
@AllArgsConstructor
public class StringProducerController {
    
    private final StringProducerService producerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void sendMessage(@RequestBody String message) {
        producerService.sendMessage(message);
    }

}
