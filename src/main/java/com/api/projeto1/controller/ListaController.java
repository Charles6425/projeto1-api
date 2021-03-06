package com.api.projeto1.controller;

import com.api.projeto1.dto.ListaDTO;
import com.api.projeto1.model.Lista;
import com.api.projeto1.service.ListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<Lista> create (@RequestBody Lista lista ){
        lista = listaService.create(lista);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(lista.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ListaDTO> update (@PathVariable Integer id,
                                            @RequestBody ListaDTO listaDTO){
        Lista  newLista = listaService.update(id, listaDTO);
        return ResponseEntity.ok().body(new ListaDTO(newLista));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void>delete(@PathVariable Integer id){
        listaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
