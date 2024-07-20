package com.example.Library.api;

import com.example.Library.dto.BookRequest;
import com.example.Library.dto.RateRequest;
import com.example.Library.model.Rate;
import com.example.Library.service.RateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/Rate")
@RequiredArgsConstructor
@RestController
public class RateController {
    private final RateService rateService;

    @PostMapping
    public ResponseEntity<Rate> rateBook(@RequestBody RateRequest rateRequest){
        return ResponseEntity.ok(rateService.rateBook(rateRequest));
    }
}
