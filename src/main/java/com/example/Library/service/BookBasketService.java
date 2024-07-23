package com.example.Library.service;

import com.example.Library.dto.BookBasketRequest;
import com.example.Library.exeption.ResourceNotFound;
import com.example.Library.model.Account;
import com.example.Library.model.Book;
import com.example.Library.model.BookBasket;
import com.example.Library.model.User;
import com.example.Library.repository.AccountRepository;
import com.example.Library.repository.BookBasketRepository;
import com.example.Library.repository.BookRepository;
import com.example.Library.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class BookBasketService {
    private final BookBasketRepository bookBasketRepository;
    private final AccountRepository accountRepository;
    private final BookRepository bookRepository;

    public BookBasket addBookBasket(){
        return bookBasketRepository.save(BookBasket.builder().build());
    }

    public BookBasket addBookToBasket(BookBasketRequest bookBasketRequest){
        Account account = accountRepository.findById(bookBasketRequest.getAccountId())
                .orElseThrow(ResourceNotFound.instance("User not found !!!"));
        Book book = bookRepository.findById(bookBasketRequest.getBookId())
                .orElseThrow(ResourceNotFound.instance("Book not found"));

        BookBasket bookBasket = account.getBookBasket();
        bookBasket.getBooks().add(book);

        return bookBasket;
    }

    public BookBasket removeBookFromBasket(Long bookId, Long accountId){
        Account account = accountRepository.findById(accountId)
                .orElseThrow(ResourceNotFound.instance("User not found !!!"));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(ResourceNotFound.instance("Book not found"));

        BookBasket bookBasket = account.getBookBasket();
        bookBasket.getBooks().remove(book);

        return bookBasket;
    }
}
