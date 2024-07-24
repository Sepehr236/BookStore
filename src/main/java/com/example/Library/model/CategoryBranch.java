package com.example.Library.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class CategoryBranch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String branchName;

    @Version
    private Long version;
}
