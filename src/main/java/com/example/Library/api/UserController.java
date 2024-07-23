package com.example.Library.api;

import com.example.Library.dto.BookBasketRequest;
import com.example.Library.dto.UserRequest;
import com.example.Library.model.Account;
import com.example.Library.model.BookBasket;
import com.example.Library.model.User;
import com.example.Library.service.AccountService;
import com.example.Library.service.BookBasketService;
import com.example.Library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/User")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final AccountService accountService;
    private final BookBasketService bookBasketService;

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody UserRequest userRequest){
        bookBasketService.addBookBasket();
        return ResponseEntity.ok(accountService.addAccount(userRequest));
    }

    @PostMapping("addBookToBasket")
    public ResponseEntity<BookBasket> addBookToBasket(@RequestBody BookBasketRequest bookBasketRequest){
        return ResponseEntity.ok(bookBasketService.addBookToBasket(bookBasketRequest));
    }

    @PostMapping("buyBook/{id}")
    public void buyBook(@PathVariable("id") Long accountId,@RequestBody Long bookId){
        accountService.buyBook(accountId, bookId);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user){
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
    }

    @DeleteMapping("removeBookFromBasket/{accountId}")
    public ResponseEntity<BookBasket> removeBookFromBasket(@PathVariable("accountId") Long accountId
            , @RequestBody Long bookId){

        return ResponseEntity.ok(bookBasketService.removeBookFromBasket(bookId, accountId));
    }
}
