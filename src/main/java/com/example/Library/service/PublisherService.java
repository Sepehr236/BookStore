package com.example.Library.service;

import com.example.Library.exeption.ResourceNotFound;
import com.example.Library.model.Publisher;
import com.example.Library.repository.PublisherRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PublisherService {
    private final PublisherRepository publisherRepository;

    public List<Publisher> getAllPublishers(){
        return publisherRepository.findAll();
    }

    public Publisher getPublisherById(Long id){
        return publisherRepository.findById(id).orElseThrow(ResourceNotFound.instance("Publisher not found!!!"));
    }

    public Publisher addPublisher(Publisher publisher){
        return publisherRepository.save(publisher);
    }

    public Publisher updatePublisher(Long id, Publisher updatedPublisher){
        Publisher publisher = getPublisherById(id);

        publisher.setName(updatedPublisher.getName());
        publisher.setAbout(updatedPublisher.getAbout());
        return publisherRepository.save(publisher);
    }

    public void deletePublisher(Long id){
        Publisher publisher = getPublisherById(id);
        publisherRepository.delete(publisher);
    }
}
