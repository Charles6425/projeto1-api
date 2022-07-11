package com.api.projeto1.dto;

import com.api.projeto1.model.Nome;

import java.io.Serializable;

public class NomeDTO implements Serializable {
    private Integer id;
    private String nome;

    public NomeDTO(){
        super();
    }
    public NomeDTO(Nome obj) {
        super();
        this.id = obj.getId();
        this.nome = obj.getNome();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
