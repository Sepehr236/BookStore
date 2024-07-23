package com.example.Library.service;

import com.example.Library.model.Category;
import com.example.Library.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Category addCategory(Category category){
        return categoryRepository.save(Category.builder()
                        .category(category.getCategory())
                .build());
    }

    public void deleteCategory(Long categoryId){
        categoryRepository.deleteById(categoryId);
    }
}
