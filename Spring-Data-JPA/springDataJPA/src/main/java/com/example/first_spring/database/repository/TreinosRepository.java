package com.example.first_spring.database.repository;

import com.example.first_spring.database.model.TreinoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TreinosRepository extends JpaRepository<TreinoEntity, Integer> {

    Optional<TreinoEntity> findByNomeAndAlunosEntityId(String nome, Integer alunoId);
}
