package com.bookstrore.jpa.services;

import com.bookstrore.jpa.dto.BookDto;
import com.bookstrore.jpa.model.BookEntity;
import com.bookstrore.jpa.model.ReviewEntity;
import com.bookstrore.jpa.repositories.AuthorRepository;
import com.bookstrore.jpa.repositories.BookRepository;
import com.bookstrore.jpa.repositories.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    @Transactional
    public BookEntity saveBook(BookDto bookDto){
        BookEntity book = new BookEntity();
        book.setTitle(bookDto.title());
        book.setAuthors(authorRepository.findAllById(bookDto.authorIds())
                .stream().collect(Collectors.toSet()));
        book.setPublisher(publisherRepository.findById(bookDto.publisherId()).get());

        ReviewEntity review = new ReviewEntity();
        review.setBook(book);
        review.setComment(bookDto.reviewComment());
        book.setReview(review);

        return bookRepository.save(book);
    }
}
