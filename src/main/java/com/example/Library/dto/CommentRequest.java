package com.example.Library.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentRequest {
    private Long bookId;
    private Long accountId;
    private String comment;
}
