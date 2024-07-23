package com.example.Library.repository;

import com.example.Library.model.Account;
import com.example.Library.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User , Long> {
    @Query(value = "SELECT u FROM User u WHERE u.account = :account")
    User findByAccount(@Param("account") Account account);
}
