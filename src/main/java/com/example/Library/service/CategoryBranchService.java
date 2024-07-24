package com.example.Library.service;

import com.example.Library.exeption.ResourceNotFound;
import com.example.Library.model.Book;
import com.example.Library.model.CategoryBranch;
import com.example.Library.repository.BookRepository;
import com.example.Library.repository.CategoryBranchRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryBranchService {
    private final CategoryBranchRepository categoryBranchRepository;
    private final BookRepository bookRepository;

    public CategoryBranch addBranch(CategoryBranch categoryBranch){
        return categoryBranchRepository.save(CategoryBranch.builder()
                        .branchName(categoryBranch.getBranchName())
                .build());
    }

    public List<Book> addBookToBranch(Long branchId, Long bookId){
        CategoryBranch categoryBranch = categoryBranchRepository.findById(branchId)
                .orElseThrow(ResourceNotFound.instance("Branch not found !!!"));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(ResourceNotFound.instance("Book not found !!!"));

        categoryBranch.getBooks().add(book);
        return categoryBranch.getBooks();
    }

    public void deleteBookFromBranch(Long branchId, Long bookId){
        CategoryBranch categoryBranch = categoryBranchRepository.findById(branchId)
                .orElseThrow(ResourceNotFound.instance("Branch not found !!!"));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(ResourceNotFound.instance("Book not found !!!"));

        categoryBranch.getBooks().remove(book);
    }
}
