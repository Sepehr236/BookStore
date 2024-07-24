package com.example.Library.api;

import com.example.Library.model.Book;
import com.example.Library.model.CategoryBranch;
import com.example.Library.repository.CategoryBranchRepository;
import com.example.Library.service.CategoryBranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/Branch")
@RestController
@RequiredArgsConstructor
public class BranchController {
    private final CategoryBranchService categoryBranchService;

    @PostMapping
    public ResponseEntity<CategoryBranch> addBranch(CategoryBranch categoryBranch){
        return ResponseEntity.ok(categoryBranchService.addBranch(categoryBranch));
    }

    @GetMapping("/{branchId}")
    public ResponseEntity<List<Book>> addBookToBranch(@PathVariable("branchId") Long branchId
            , @RequestBody Long bookId){

        return ResponseEntity.ok(categoryBranchService.addBookToBranch(branchId, bookId));
    }

    @GetMapping("/{branchId}")
    public ResponseEntity<List<Book>> getBookByBranch(@PathVariable("branchId") Long branchId){
        return ResponseEntity.ok(categoryBranchService.getBooksByBranch(branchId));
    }

    @DeleteMapping("/{branchId}")
    public void deleteBookFromBranch(@PathVariable("branchId") Long branchId, @RequestBody Long bookId){
        categoryBranchService.deleteBookFromBranch(branchId, bookId);
    }
}
