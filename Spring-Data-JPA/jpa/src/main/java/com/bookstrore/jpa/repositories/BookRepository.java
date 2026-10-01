package com.bookstrore.jpa.repositories;

import com.bookstrore.jpa.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface BookRepository extends JpaRepository<BookEntity, UUID> {

    BookEntity findBookEntityByTitle(String title);

    @Query(value = "SELECT * FROM book WHERE publisher_id = :id", nativeQuery = true )
    List<BookEntity> findBooksByPublisherId(@Param("id") UUID id);

}
