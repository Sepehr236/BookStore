package com.example.Library.API;

import com.example.Library.DTO.RateRequest;
import com.example.Library.Model.Book;
import com.example.Library.Model.Rate;
import com.example.Library.Model.User;
import com.example.Library.Service.RateService;
import com.example.Library.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/User")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final RateService rateService;

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        return ResponseEntity.ok(userService.addUser(user));
    }

    @PostMapping("/rate")
    public ResponseEntity<Rate> rateBook(@RequestBody RateRequest rateRequest){
        return ResponseEntity.ok(rateService.rateBook(rateRequest));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user){
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    @PutMapping("/updateRate")
    public ResponseEntity<Rate> updateRate(@RequestBody Long id, Integer newRate){
        return ResponseEntity.ok(rateService.updateRate(id, newRate));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
    }

    @DeleteMapping("/deleteRate/{id}")
    public void deleteRate(@PathVariable("id") Long id){
        rateService.deleteRate(id);
    }
}
