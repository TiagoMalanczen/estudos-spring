package com.bookstrore.jpa.repositories;

import com.bookstrore.jpa.model.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PublisherRepository extends JpaRepository<PublisherEntity, UUID> {


}
