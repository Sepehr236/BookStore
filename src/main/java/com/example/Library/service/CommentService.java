package com.example.Library.service;

import com.example.Library.exeption.ResourceNotFound;
import com.example.Library.model.Book;
import com.example.Library.model.Comment;
import com.example.Library.repository.BookRepository;
import com.example.Library.repository.CommentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final BookRepository bookRepository;

    public Comment addComment(Long bookId, Comment comment){
        Book book = bookRepository.findById(bookId)
                .orElseThrow(ResourceNotFound.instance("Book not found !!!"));

        book.getComments().add(comment);
        return comment;
    }
}
