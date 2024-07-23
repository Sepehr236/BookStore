package com.example.Library.repository;

import com.example.Library.model.BookBasket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookBasketRepository extends JpaRepository<BookBasket, Long> {
}
