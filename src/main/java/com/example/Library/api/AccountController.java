package com.example.Library.api;

import com.example.Library.dto.BuyRequest;
import com.example.Library.model.Account;
import com.example.Library.service.AccountService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/BuyBook")
@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping()
    public ResponseEntity<Account> buyBook(@RequestBody BuyRequest buyRequest){
        return ResponseEntity.ok(accountService.buyBook(buyRequest.getAccountId(), buyRequest.getBookId()));
    }
}
