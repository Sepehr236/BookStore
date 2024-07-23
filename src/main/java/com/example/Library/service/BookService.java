package com.example.Library.service;

import com.example.Library.dto.BookRequest;
import com.example.Library.exeption.ResourceNotFound;
import com.example.Library.model.Author;
import com.example.Library.model.Book;
import com.example.Library.model.Publisher;
import com.example.Library.model.Translator;
import com.example.Library.repository.AuthorRepository;
import com.example.Library.repository.BookRepository;
import com.example.Library.repository.PublisherRepository;
import com.example.Library.repository.TranslatorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;
    private final TranslatorRepository translatorRepository;
    private final BookRepository bookRepository;

    public Book addBook(BookRequest bookRequest){
        Author author = authorRepository.findById(bookRequest.getAuthorId())
                .orElseThrow(ResourceNotFound.instance("Author not found!!!"));
        Publisher publisher = publisherRepository.findById(bookRequest.getPublisherId())
                .orElseThrow(ResourceNotFound.instance("Publisher not found!!!"));
        Translator translator = translatorRepository.findById(bookRequest.getTranslatorId())
                .orElseThrow(ResourceNotFound.instance("Translator not found!!!"));



        return bookRepository.save(Book.builder()
                        .publisher(publisher)
                        .author(author)
                        .translator(translator)
                        .name(bookRequest.getName())
                        .about(bookRequest.getAbout())
                        .language(bookRequest.getLanguage())
                        .price(bookRequest.getPrice())
                        .numberOfPages(bookRequest.getNumberOfPages())
                        .publishDate(bookRequest.getPublishDate())
                        .fiveStars(0)
                        .fourStars(0)
                        .threeStars(0)
                        .twoStars(0)
                        .oneStars(0)
                        .overAllRate(0.0)

                .build());
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBookById(Long id){
        return bookRepository.findById(id).orElseThrow(ResourceNotFound.instance("Book not found"));
    }

    public Book updateBook(Long id, BookRequest bookRequest){
        Book book = getBookById(id);
        Author author = authorRepository.findById(bookRequest.getAuthorId())
                .orElseThrow(ResourceNotFound.instance("Author not found!!!"));
        Publisher publisher = publisherRepository.findById(bookRequest.getPublisherId())
                .orElseThrow(ResourceNotFound.instance("Publisher not found!!!"));
        Translator translator = translatorRepository.findById(bookRequest.getTranslatorId())
                .orElseThrow(ResourceNotFound.instance("Translator not found!!!"));

        book.setName(bookRequest.getName());
        book.setAbout(bookRequest.getAbout());
        book.setLanguage(bookRequest.getLanguage());
        book.setPrice(bookRequest.getPrice());
        book.setNumberOfPages(bookRequest.getNumberOfPages());
        book.setPublishDate(bookRequest.getPublishDate());
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setTranslator(translator);

        return bookRepository.save(book);
    }

    public void deleteBook(Long id){
        Book book = getBookById(id);
        bookRepository.delete(book);
    }

    public Book searchBook(String name){
        return bookRepository.findByName(name);
    }
}
