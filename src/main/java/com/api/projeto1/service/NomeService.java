package com.api.projeto1.service;


import com.api.projeto1.model.Lista;
import com.api.projeto1.model.Nome;
import com.api.projeto1.repository.ListaRepository;
import com.api.projeto1.repository.NomeRepository;
import com.api.projeto1.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NomeService {
    @Autowired
    private NomeRepository nomeRepository;

    @Autowired
    private ListaService listaService;
    private Lista lista;

    public Nome findById(Integer id) {
        Optional<Nome> nome = nomeRepository.findById(id);
        return nome.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "
                + id + " Tipo: " + Nome.class.getName()));
    }

    public List<Nome> findAll() {
        List<Nome> nome = nomeRepository.findAll();
        return nome;
    }

    public List<Nome> findAllByLista(Integer id_lista) {
        listaService.findById(id_lista);
        return nomeRepository.findAllByLista(id_lista);

    }

    public Nome create(Nome nome, Integer lista_id) {
        nome.setId(null);
        Lista lista = listaService.findById(lista_id);
        nome.setLista(lista);
        return nomeRepository.save(nome);
    }


    public void delete(Integer id) {
        Nome nome = findById(id);
        nomeRepository.delete(nome);
    }

    public Nome update(Nome nome, Integer id_nome, Integer id_lista) {
        Nome newNome = findById(id_nome);
        if(id_lista!=0 ){
            Lista newLista = listaService.findById(id_lista);
            newNome.setLista(newLista);
        } else{
            Lista newLista = listaService.findById(newNome.getLista().getId());
            newNome.setLista(newLista);
        }
        newNome.setNome(nome.getNome());
        newNome.setId(nome.getId());
        return nomeRepository.save(newNome);
    }
}
