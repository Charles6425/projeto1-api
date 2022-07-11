package com.api.projeto1.controller;

import com.api.projeto1.dto.ListaDTO;
import com.api.projeto1.dto.NomeDTO;
import com.api.projeto1.model.Nome;
import com.api.projeto1.service.NomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

//    @GetMapping
//    public ResponseEntity<List<Nome>> fundAll(){
//        List<Nome> nome = nomeService.findAll();
//        return ResponseEntity.ok(nome);
//    }

    @GetMapping
    public ResponseEntity<List<NomeDTO>> fundAllByLista(@RequestParam(value = "lista", defaultValue = "0")
                                                         Integer id_lista){
        List<Nome> nome = nomeService.findAllByLista(id_lista);
        List<NomeDTO> nomeDTO = nome.stream().map(obj-> new NomeDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(nomeDTO);
    }
}
