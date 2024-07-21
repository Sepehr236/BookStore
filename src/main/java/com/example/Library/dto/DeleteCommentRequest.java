package com.example.Library.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteCommentRequest {
    private Long bookId;
    private Long commentId;
}
