package com.example.Library.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RateRequest {
    private Integer rate;
    private Long userId;
    private Long bookId;
}
