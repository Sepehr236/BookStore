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
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long amount;

    @OneToMany
    private List<Book> books;

    @OneToOne
    private BookBasket bookBasket;

    @Version
    private Long version;
}
