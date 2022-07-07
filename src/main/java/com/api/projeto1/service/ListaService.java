package com.api.projeto1.service;


import com.api.projeto1.model.Lista;
import com.api.projeto1.repository.ListaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ListaService {
    @Autowired
    private ListaRepository listaRepository;

    public Lista findById(Integer id){
        Optional<Lista> obj = listaRepository.findById(id);
        return obj.orElse(null);
    }
}
