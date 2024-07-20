package com.example.Library.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {
    private String name;
    private String about;
    private String language;
    private String price;
    private Long numberOfPages;
    private String publishDate;
    private Long publisherId;
    private Long authorId;
    private Long translatorId;
}
