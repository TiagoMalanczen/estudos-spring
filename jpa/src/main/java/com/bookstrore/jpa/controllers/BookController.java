package com.bookstrore.jpa.controllers;

import com.bookstrore.jpa.dto.BookDto;
import com.bookstrore.jpa.model.BookEntity;
import com.bookstrore.jpa.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveBook(@RequestBody BookDto bookDto){
        bookService.saveBook(bookDto);
    }

}
