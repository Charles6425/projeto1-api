package com.api.projeto1.dto;

import com.api.projeto1.model.Lista;

import java.io.Serializable;

public class ListaDTO implements Serializable {
    private Integer id;
    private String descricao;

    public ListaDTO(){
        super();
    }

    public ListaDTO(Lista lista) {
        super();
        this.id = lista.getId();
        this.descricao = lista.getDescricao();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
