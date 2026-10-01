package com.bookstrore.jpa.repositories;

import com.bookstrore.jpa.model.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface Review extends JpaRepository<ReviewEntity, UUID> {

}
