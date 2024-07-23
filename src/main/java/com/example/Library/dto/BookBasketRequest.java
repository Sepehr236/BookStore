package com.example.Library.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookBasketRequest {
    private Long accountId;
    private Long bookId;
}
