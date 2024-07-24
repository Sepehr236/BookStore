package com.example.Library.service;

import com.example.Library.dto.AudioBookRequest;
import com.example.Library.exeption.ResourceNotFound;
import com.example.Library.model.*;
import com.example.Library.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class AudioBookService {
    private final AudioBookRepository audioBookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;
    private final TranslatorRepository translatorRepository;
    private final NarratorRepository narratorRepository;

    public AudioBook addAudioBook(AudioBookRequest audioBookRequest){
        Author author = authorRepository.findById(audioBookRequest.getAuthorId())
                .orElseThrow(ResourceNotFound.instance("Author not found!!!"));
        Publisher publisher = publisherRepository.findById(audioBookRequest.getPublisherId())
                .orElseThrow(ResourceNotFound.instance("Publisher not found!!!"));
        Translator translator = translatorRepository.findById(audioBookRequest.getTranslatorId())
                .orElseThrow(ResourceNotFound.instance("Translator not found!!!"));
        Narrator narrator = narratorRepository.findById(audioBookRequest.getNarratorId())
                .orElseThrow(ResourceNotFound.instance("Narrator not found !!!"));

        return audioBookRepository.save(AudioBook.builder()
                .narrator(narrator)
                .publisher(publisher)
                .author(author)
                .translator(translator)
                .name(audioBookRequest.getName())
                .about(audioBookRequest.getAbout())
                .language(audioBookRequest.getLanguage())
                .price(audioBookRequest.getPrice())
                .numberOfPages(audioBookRequest.getNumberOfPages())
                .publishDate(audioBookRequest.getPublishDate())
                .fiveStars(0)
                .fourStars(0)
                .threeStars(0)
                .twoStars(0)
                .oneStars(0)
                .overAllRate(0.0)
                .build());
    }

    public void deleteAudioBook(Long audioBookId){
        audioBookRepository.deleteById(audioBookId);
    }
}
