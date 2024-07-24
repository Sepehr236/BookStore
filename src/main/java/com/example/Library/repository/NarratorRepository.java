package com.example.Library.repository;

import com.example.Library.model.Narrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NarratorRepository extends JpaRepository<Narrator, Long> {
}
