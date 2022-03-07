package com.cursorabbitmq.cursoRabbitMQ.controller;

import com.cursorabbitmq.cursoRabbitMQ.dto.EstoqueDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="estoque")
public class EstoqueController {
    @PutMapping
    private ResponseEntity alteraEstoque(@RequestBody EstoqueDto estoqueDto){

        return new ResponseEntity(HttpStatus.OK);



    }
}
