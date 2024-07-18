package com.example.Library.Service;

import com.example.Library.Exeption.ResourceNotFound;
import com.example.Library.Model.Book;
import com.example.Library.Model.Comment;
import com.example.Library.Repository.BookRepository;
import com.example.Library.Repository.CommentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final BookRepository bookRepository;
    public Book addComment(Long bookId, Comment comment){
        Book book =  bookRepository.findById(bookId).orElseThrow(ResourceNotFound.instance("Book not found !!!"));

        book.getComments().add(comment);
        book.setComments(book.getComments());

        return book;
    }
}
