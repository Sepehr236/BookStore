package com.example.Library.DTO;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RateRequest {
    private Integer rate;
    private Long bookId;
    private Long userId;
}
