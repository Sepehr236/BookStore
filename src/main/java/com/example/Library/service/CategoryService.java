package com.example.Library.service;

import com.example.Library.exeption.ResourceNotFound;
import com.example.Library.model.Book;
import com.example.Library.model.Category;
import com.example.Library.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Book> getBookByCategory(Long categoryId){
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(ResourceNotFound.instance("Category not found !!!"));

        return category.getBooks();
    }

    public void deleteCategory(Long categoryId){
        categoryRepository.deleteById(categoryId);
    }
}
