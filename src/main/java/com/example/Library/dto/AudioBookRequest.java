package com.example.Library.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AudioBookRequest {
    private String name;
    private String about;
    private String language;
    private Long price;
    private Long numberOfPages;
    private String publishDate;
    private Long publisherId;
    private Long authorId;
    private Long translatorId;
    private Long narratorId;
    private String narratingTime;
}
