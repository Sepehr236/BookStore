package com.example.Library.dto;

import com.example.Library.model.Account;
import com.example.Library.model.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
    private User user;
    private Account account;
}
