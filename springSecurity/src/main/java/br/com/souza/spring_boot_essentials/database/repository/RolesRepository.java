package br.com.souza.spring_boot_essentials.database.repository;

import br.com.souza.spring_boot_essentials.database.model.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolesRepository extends JpaRepository<RolesEntity, Integer> {

    Optional<RolesEntity> findByNome(String role);
}
