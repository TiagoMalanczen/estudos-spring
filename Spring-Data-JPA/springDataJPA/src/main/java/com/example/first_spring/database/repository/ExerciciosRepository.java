package com.example.first_spring.database.repository;

import com.example.first_spring.database.model.ExerciciosEntity;
import jakarta.persistence.NamedNativeQueries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;
import java.util.List;

public interface ExerciciosRepository extends JpaRepository<ExerciciosEntity, Integer> {

    List<ExerciciosEntity> findAllByGrupoMuscular(String grupoMuscular);

    @Query(value = " SELECT e FROM ExercicioEntity e  " +
            "WHERE UPPER(e.grupoMuscular) = UPPER(:grupoMuscular) ")
    List<ExerciciosEntity> findAllByGrupoMuscularJpql(String grupoMuscular);


}
