package com.example.Library.api;

import com.example.Library.model.Book;
import com.example.Library.model.Category;
import com.example.Library.service.CategoryService;
import com.example.Library.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> addCategory(Category category){
        return ResponseEntity.ok(categoryService.addCategory(category));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Book>> getBookByCategory(@PathVariable("id") Long id){
        return ResponseEntity.ok(categoryService.getBookByCategory(id));
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") Long id){
        categoryService.deleteCategory(id);
    }
}
