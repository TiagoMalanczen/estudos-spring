package com.bookstrore.jpa.repositories;

import com.bookstrore.jpa.model.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<AuthorEntity, UUID> {


}
