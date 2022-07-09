package com.api.projeto1.controller;

import com.api.projeto1.dto.ListaDTO;
import com.api.projeto1.model.Lista;
import com.api.projeto1.service.ListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/lista")
public class ListaController {
    @Autowired
    private ListaService listaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Lista> findById(@PathVariable Integer id){
        Lista obj = listaService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<ListaDTO>> findAll(){
        List<Lista> lista = listaService.findAll();
        List<ListaDTO> listaDTO = lista.stream().map(obj-> new ListaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listaDTO);
    }
}
