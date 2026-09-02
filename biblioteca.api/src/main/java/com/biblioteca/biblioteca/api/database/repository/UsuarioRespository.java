package com.biblioteca.biblioteca.api.database.repository;

import com.biblioteca.biblioteca.api.database.model.UsuarioEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRespository extends JpaRepository<UsuarioEntity, Integer> {

    Optional<UsuarioEntity> findByMatricula(String matricula);
    Optional<UsuarioEntity> findByEmail(String email);

}

