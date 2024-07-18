package com.example.Library.DTO;

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
    private String publisherName;
    private Long publisherId;
    private String authorName;
    private Long authorId;
    private String translatorName;
    private Long translatorId;
}
