package com.example.Library.model;

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

    @OneToOne
    private Account account;

    @Version
    private Long version;
}
