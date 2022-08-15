package com.api.projeto1.controller;

import com.api.projeto1.dto.ListaDTO;
import com.api.projeto1.dto.NomeDTO;
import com.api.projeto1.model.Nome;
import com.api.projeto1.service.NomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping(value = "/todos")
    public ResponseEntity<List<Nome>> todos(){
        List<Nome> nome =nomeService.findAll();
        return ResponseEntity.ok().body(nome);
    }

    @GetMapping
    public ResponseEntity<List<NomeDTO>> findAllByLista(@RequestParam(value = "lista", defaultValue = "0")
                                                         Integer id_lista){
        List<Nome> nome = nomeService.findAllByLista(id_lista);
        List<NomeDTO> nomeDTO = nome.stream().map(obj-> new NomeDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(nomeDTO);
    }

    @PostMapping
    public ResponseEntity<Nome> create (@RequestBody Nome nome,
                                        @RequestParam(value = "lista", defaultValue = "0")
                                        Integer lista_id){
       Nome newNome = nomeService.create(nome, lista_id);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newNome.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
