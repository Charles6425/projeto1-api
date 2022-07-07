package com.api.projeto1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lista {
    private int id;
    private String descricao;
    private List<Nome> nomes = new ArrayList<>();

    public Lista(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
    public Lista(){
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Nome> getNomes() {
        return nomes;
    }

    public void setNomes(List<Nome> nomes) {
        this.nomes = nomes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lista)) return false;
        Lista lista = (Lista) o;
        return id == lista.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}