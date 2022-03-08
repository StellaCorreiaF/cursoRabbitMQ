package com.cursorabbitmq.cursoRabbitMQ.controller;

import com.cursorabbitmq.cursoRabbitMQ.constantes.RabbitMQConstantes;
import com.cursorabbitmq.cursoRabbitMQ.dto.PrecoDto;
import com.cursorabbitmq.cursoRabbitMQ.service.RabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="preco")
public class PrecoController {
    @Autowired
    private RabbitMQService rabbitMQService;

    @PutMapping
    private ResponseEntity alterarPreco(@RequestBody PrecoDto precoDto) {
        System.out.println(precoDto.preco);

        this.rabbitMQService.enviarMensagem(RabbitMQConstantes.FILA_PRECO, precoDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
