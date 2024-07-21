package com.example.Library.service;

import com.example.Library.dto.UserRequest;
import com.example.Library.exeption.ResourceNotFound;
import com.example.Library.model.Account;
import com.example.Library.model.User;
import com.example.Library.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User addUser(UserRequest userRequest){
        return userRepository.save(User.builder()
                        .name(userRequest.getName())
                        .gmail(userRequest.getGmail())
                        .phoneNumber(userRequest.getPhoneNumber())
                        .password(userRequest.getPassword())
                .build());
    }

    public User getUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(ResourceNotFound.instance("User not found!!!"));
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User updateUser(Long id, User updatedUser){
        User user = getUserById(id);
        user.setName(updatedUser.getName());
        user.setGmail(updatedUser.getGmail());
        user.setPhoneNumber(updatedUser.getPhoneNumber());
        user.setPassword(updatedUser.getPassword());

        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        User user = getUserById(id);

        userRepository.delete(user);
    }
}
