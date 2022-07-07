package com.api.projeto1.service;

import com.api.projeto1.model.Nome;
import com.api.projeto1.repository.NomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NomeService {
    @Autowired
    private NomeRepository nomeRepository;

    public Nome findById(Integer id){
      Optional<Nome> nome = nomeRepository.findById(id);
        return nome.orElse(null);
    }


}
