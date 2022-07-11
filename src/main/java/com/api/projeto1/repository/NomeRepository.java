package com.api.projeto1.repository;

import com.api.projeto1.model.Nome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NomeRepository extends JpaRepository<Nome, Integer> {
    @Query("SELECT obj FROM Nome obj WHERE obj.lista.id = :id_lista")
    List<Nome> findAllByLista(@Param(value = "id_lista") Integer id_lista);
}
