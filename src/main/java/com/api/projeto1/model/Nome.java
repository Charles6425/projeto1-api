package com.api.projeto1.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
@Entity
public class Nome implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "lista_id")
    private Lista lista;

    public Nome(int id, String nome, Lista lista) {
        this.id = id;
        this.nome = nome;
        this.lista = lista;
    }

    public Nome(){
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Nome)) return false;
        Nome nome = (Nome) o;
        return id == nome.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
