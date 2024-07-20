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



        Book book =  bookRepository.save(Book.builder()
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

        author.getBooks().add(book);
        publisher.getBooks().add(book);
        translator.getBooks().add(book);

        return book;
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBookById(Long id){
        return bookRepository.findById(id).orElseThrow(ResourceNotFound.instance("Book not found"));
    }

    public Book updateBook(Long id, BookRequest bookRequest){
        Book book = getBookById(id);
        Author author = book.getAuthor();
        author.getBooks().remove(book);
        Publisher publisher = book.getPublisher();
        publisher.getBooks().remove(book);
        Translator translator = book.getTranslator();
        translator.getBooks().remove(book);


        Author updatedAuthor = authorRepository.findById(bookRequest.getAuthorId())
                .orElseThrow(ResourceNotFound.instance("Author not found!!!"));
        Publisher updatedPublisher = publisherRepository.findById(bookRequest.getPublisherId())
                .orElseThrow(ResourceNotFound.instance("Publisher not found!!!"));
        Translator updatedTranslator = translatorRepository.findById(bookRequest.getTranslatorId())
                .orElseThrow(ResourceNotFound.instance("Translator not found!!!"));

        book.setName(bookRequest.getName());
        book.setAbout(bookRequest.getAbout());
        book.setLanguage(bookRequest.getLanguage());
        book.setPrice(bookRequest.getPrice());
        book.setNumberOfPages(bookRequest.getNumberOfPages());
        book.setPublishDate(bookRequest.getPublishDate());
        book.setAuthor(updatedAuthor);
        book.setPublisher(updatedPublisher);
        book.setTranslator(updatedTranslator);

        return bookRepository.save(book);
    }

    public void deleteBook(Long id){
        Book book = getBookById(id);
        bookRepository.delete(book);
    }
}
