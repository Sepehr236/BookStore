package com.example.Library.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "Users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String gmail;
    private String phoneNumber;
    private String password;
    private Long walletAmount;

    @OneToMany
    @JoinColumn
    private List<Book> books;

    @OneToMany
    @JoinColumn
    private List<Rate> rates;

    @Version
    private Long version;
}
