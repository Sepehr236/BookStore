package com.example.Library.api;

import com.example.Library.model.Category;
import com.example.Library.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/Category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> addCategory(Category category){
        return ResponseEntity.ok(categoryService.addCategory(category));
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") Long id){
        categoryService.deleteCategory(id);
    }
}
