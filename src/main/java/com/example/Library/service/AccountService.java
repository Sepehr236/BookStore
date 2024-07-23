package com.example.Library.service;

import com.example.Library.dto.UserRequest;
import com.example.Library.exeption.ResourceNotFound;
import com.example.Library.model.Account;
import com.example.Library.model.Book;
import com.example.Library.model.BookBasket;
import com.example.Library.model.User;
import com.example.Library.repository.AccountRepository;
import com.example.Library.repository.BookRepository;
import com.example.Library.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Transactional
@RequiredArgsConstructor
@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final UserService userService;
    private final BookBasketService bookBasketService;

    public User addAccount(UserRequest userRequest){
        User user = userService.addUser(userRequest);
        Account account = accountRepository.save(Account.builder()
                        .amount(userRequest.getAmount())
                .build());

        user.setAccount(account);
        return user;
    }

    public Account buyBook(Long accountId, Long bookId){
        Account account = accountRepository.findById(accountId)
                .orElseThrow(ResourceNotFound.instance("Account not found !!!"));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(ResourceNotFound.instance("Book not found !!!"));

        if(book.getPrice() <= account.getAmount()){
            account.setAmount(account.getAmount() - book.getPrice());
            account.getBooks().add(book);
            if(account.getBookBasket().getBooks().contains(book)){
                BookBasket bookBasket = bookBasketService.removeBookFromBasket(accountId, bookId);
            }
            return account;
        }else{
            throw ResourceNotFound.instance("Budget not enough !!!");
        }
    }
}
