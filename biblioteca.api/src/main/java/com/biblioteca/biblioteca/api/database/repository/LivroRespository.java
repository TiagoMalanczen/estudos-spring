package com.biblioteca.biblioteca.api.database.repository;

import com.biblioteca.biblioteca.api.database.model.LivroEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LivroRespository extends JpaRepository<LivroEntity, Integer> {

    Page<LivroEntity> findAll(Pageable pageable);

    Optional<LivroEntity> findByIsbm(String isbm);
}
