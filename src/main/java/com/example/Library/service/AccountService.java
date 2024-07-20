package com.example.Library.service;

import com.example.Library.exeption.ResourceNotFound;
import com.example.Library.model.Account;
import com.example.Library.model.Book;
import com.example.Library.repository.AccountRepository;
import com.example.Library.repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Transactional
@RequiredArgsConstructor
@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final BookRepository bookRepository;

    public Account addAccount(Account account){
        return accountRepository.save(Account.builder()
                        .amount(account.getAmount())
                .build());
    }

    public void buyBook(Long accountId, Long bookId){
        Account account = accountRepository.findById(accountId)
                .orElseThrow(ResourceNotFound.instance("Account not found !!!"));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(ResourceNotFound.instance("Book not found !!!"));

        if(book.getPrice() <= account.getAmount()){
            account.setAmount(account.getAmount() - book.getPrice());
            account.getBooks().add(book);
        }else{
            throw ResourceNotFound.instance("Budget not enough !!!");
        }

    }
}
