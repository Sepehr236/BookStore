package com.example.Library.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer rate;

    @OneToOne
    @JoinColumn
    private User user;

    @OneToOne
    @JoinColumn
    private Book book;

    @Version
    private Long version;
}
