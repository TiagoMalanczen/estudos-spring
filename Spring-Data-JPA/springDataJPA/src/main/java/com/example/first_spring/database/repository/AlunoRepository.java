package com.example.first_spring.database.repository;

import com.example.first_spring.database.model.AlunosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlunoRepository extends JpaRepository<AlunosEntity, Integer> {

    Optional<AlunosEntity> findByEmail(String email);
}
