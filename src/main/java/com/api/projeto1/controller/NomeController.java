package com.api.projeto1.controller;

import com.api.projeto1.model.Nome;
import com.api.projeto1.service.NomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/nome")
public class NomeController {
    @Autowired
    private NomeService nomeService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Nome> findById (@PathVariable Integer id){
        Nome nome = nomeService.findById(id);
        return ResponseEntity.ok().body(nome);
    }

    @GetMapping
    public ResponseEntity<List<Nome>> fundAll(){
        List<Nome> nome = nomeService.findAll();
        return ResponseEntity.ok(nome);
    }
}
