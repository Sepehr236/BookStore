package com.example.Library.service;

import com.example.Library.dto.CommentRequest;
import com.example.Library.exeption.ResourceNotFound;
import com.example.Library.model.Account;
import com.example.Library.model.Book;
import com.example.Library.model.Comment;
import com.example.Library.repository.AccountRepository;
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
    private final AccountRepository accountRepository;

    public Comment addComment(CommentRequest commentRequest){
        Book book = bookRepository.findById(commentRequest.getBookId())
                .orElseThrow(ResourceNotFound.instance("Book not found !!!"));
        Account account = accountRepository.findById(commentRequest.getAccountId())
                .orElseThrow(ResourceNotFound.instance("Account not found !!!"));

        Comment comment = commentRepository.save(Comment.builder()
                        .Comment(commentRequest.getComment())
                        .account(account)
                .build());

        book.getComments().add(comment);

        return comment;
    }
}
