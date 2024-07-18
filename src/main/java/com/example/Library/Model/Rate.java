package com.example.Library.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
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
