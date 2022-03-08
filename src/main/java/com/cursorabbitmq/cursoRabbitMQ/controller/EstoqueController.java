package com.cursorabbitmq.cursoRabbitMQ.controller;

import com.cursorabbitmq.cursoRabbitMQ.constantes.RabbitMQConstantes;
import com.cursorabbitmq.cursoRabbitMQ.dto.EstoqueDto;
import com.cursorabbitmq.cursoRabbitMQ.service.RabbitMQService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Component
@RestController
@RequestMapping(value="estoque")
public class EstoqueController {

    @Autowired
    private RabbitMQService rabbitMQService;
    @PutMapping
    private ResponseEntity alteraEstoque(@RequestBody EstoqueDto estoqueDto){
        System.out.println(estoqueDto.codigoProduto);

        this.rabbitMQService.enviarMensagem(RabbitMQConstantes.FILA_ESTOQUE, estoqueDto);

        return new ResponseEntity(HttpStatus.OK);
    }
    @RabbitListener(queues = RabbitMQConstantes.FILA_ESTOQUE)
    private void consumidor(EstoqueDto estoqueDto){
        System.out.println(estoqueDto.codigoProduto);
        System.out.println(estoqueDto.quantidade);
        System.out.println("------------------------");

    }

}
