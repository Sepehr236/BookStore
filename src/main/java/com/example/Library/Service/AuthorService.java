package com.example.Library.Service;

import com.example.Library.Exeption.ResourceNotFound;
import com.example.Library.Model.Author;
import com.example.Library.Repository.AuthorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id){
        return authorRepository.findById(id).orElseThrow(ResourceNotFound.instance("Author not found!!!"));
    }

    public Author addAuthor(Author author){
        return authorRepository.save(author);
    }

    public Author updateAuthor(Long id, Author updatedAuthor){
        Author author = getAuthorById(id);

        author.setAbout(updatedAuthor.getAbout());
        author.setName(updatedAuthor.getName());
        return authorRepository.save(author);
    }

    public void deleteAuthor(Long id){
        Author author = getAuthorById(id);
        authorRepository.delete(author);
    }
}
