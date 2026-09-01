package com.example.first_spring.database.repository;

import com.example.first_spring.database.model.AlunosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AlunoRepository extends JpaRepository<AlunosEntity, Integer> {

    Optional<AlunosEntity> findByEmail(String email);

    @Query(value = "SELECT a FROM AlunosEntity a JOIN FETCH a.avaliacaoFisica WHERE a.id = :alunoid")
    Optional<AlunosEntity> findByIdFEtch(Integer alunoId);
}
