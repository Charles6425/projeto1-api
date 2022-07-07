package com.api.projeto1.repository;

import com.api.projeto1.model.Nome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NomeRepository extends JpaRepository<Nome, Integer> {
}
