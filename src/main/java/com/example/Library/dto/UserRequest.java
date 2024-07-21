package com.example.Library.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private String name;
    private String gmail;
    private String password;
    private String phoneNumber;
    private Long amount;
}
