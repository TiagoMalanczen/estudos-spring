package com.biblioteca.biblioteca.api.database.repository;

import com.biblioteca.biblioteca.api.database.model.EmprestimoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface EmprestimoRepository extends JpaRepository<EmprestimoEntity, Integer> {

}
