package com.biblioteca.biblioteca.api.database.repository;

import com.biblioteca.biblioteca.api.database.model.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LivroRespository extends JpaRepository<LivroEntity, Integer> {

    Optional<LivroEntity> findByIsbm(String isbm);
}
