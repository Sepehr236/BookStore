package com.example.Library.repository;

import com.example.Library.model.CategoryBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryBranchRepository extends JpaRepository<CategoryBranch, Long> {
}
