package com.example.Library.Service;

import com.example.Library.Exeption.ResourceNotFound;
import com.example.Library.Model.User;
import com.example.Library.Repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User addUser(User user){
        return userRepository.save(user);
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
        user.setWalletAmount(updatedUser.getWalletAmount());

        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        User user = getUserById(id);

        userRepository.delete(user);
    }
}
