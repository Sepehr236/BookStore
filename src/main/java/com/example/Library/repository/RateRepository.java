package com.example.Library.repository;

import com.example.Library.model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {
    @Query(value = "SELECT COUNT(r) FROM Rate r")
    Integer numberOfRates();

    @Query(value = "SELECT COUNT(r) FROM Rate r WHERE r.rate = 5")
    Integer fiveStars();

    @Query(value = "SELECT COUNT(r) FROM Rate r WHERE r.rate = 4")
    Integer fourStars();

    @Query(value = "SELECT COUNT(r) FROM Rate r WHERE r.rate = 3")
    Integer threeStars();

    @Query(value = "SELECT COUNT(r) FROM Rate r WHERE r.rate = 2")
    Integer twoStars();

    @Query(value = "SELECT COUNT(r) FROM Rate r WHERE r.rate = 1")
    Integer oneStars();
}
