package com.example.Library.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Comment;

    @ManyToOne
    private User user;

    @ManyToOne
    private Book book;

    @Version
    private Long version;
}
