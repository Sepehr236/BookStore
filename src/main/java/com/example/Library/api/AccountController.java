package com.example.Library.api;

import com.example.Library.model.Account;
import com.example.Library.service.AccountService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("BuyBook")
@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/{id}")
    public ResponseEntity<Account> buyBook(@PathVariable("id") Long bookId, @RequestBody Long accountId){
        return ResponseEntity.ok(accountService.buyBook(accountId, bookId));
    }
}
