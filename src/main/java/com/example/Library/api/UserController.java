package com.example.Library.api;

import com.example.Library.model.Account;
import com.example.Library.model.User;
import com.example.Library.service.AccountService;
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

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user, Account account){
        accountService.addAccount(account);
        return ResponseEntity.ok(userService.addUser(user));
    }

    @PostMapping("buyBook/{id}")
    public void buyBook(@PathVariable("id") Long accountId, @RequestBody Long bookId){
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
}
