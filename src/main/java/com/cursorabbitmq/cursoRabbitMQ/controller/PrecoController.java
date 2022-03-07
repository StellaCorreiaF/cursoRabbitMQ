package com.cursorabbitmq.cursoRabbitMQ.controller;

import com.cursorabbitmq.cursoRabbitMQ.dto.PrecoDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="preco")
public class PrecoController {

    @PutMapping
    private ResponseEntity alterarPReco(@RequestBody PrecoDto precoDto) {
        return new ResponseEntity(HttpStatus.OK);
    }
}
