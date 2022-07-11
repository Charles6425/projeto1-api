package com.api.projeto1.service;


import com.api.projeto1.dto.ListaDTO;
import com.api.projeto1.exception.ObjectNotFoundException;
import com.api.projeto1.model.Lista;
import com.api.projeto1.repository.ListaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListaService {
    @Autowired
    private ListaRepository listaRepository;

    public Lista findById(Integer id) {
        Optional<Lista> obj = listaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "
                + id + " Tipo: " + Lista.class.getName()));
    }

    public List<Lista> findAll() {
        return listaRepository.findAll();
    }

    public Lista create (Lista lista){
        lista.setId(null);
        return listaRepository.save(lista);
    }

    public Lista update(Integer id, ListaDTO listaDTO) {
        Lista lista = findById(id);
        lista.setDescricao(listaDTO.getDescricao());
        return listaRepository.save(lista);
    }
}
