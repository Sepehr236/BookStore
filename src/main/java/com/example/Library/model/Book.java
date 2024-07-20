package com.example.Library.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String name;
    private String about;
    private String language;
    private String price;
    private Long numberOfPages;
    private Integer fiveStars;
    private Integer fourStars;
    private Integer threeStars;
    private Integer twoStars;
    private Integer oneStars;
    private Double overAllRate;
    private String publishDate;

    @OneToOne
    @JoinColumn
    private Author author;

    @OneToOne
    @JoinColumn
    private Translator translator;

    @OneToOne
    @JoinColumn
    private Publisher publisher;

    @OneToMany
    @JoinColumn
    private List<Comment> comments;

    @OneToMany
    @JoinColumn
    private List<Rate> rates;

    @Version
    private Long version;
}
