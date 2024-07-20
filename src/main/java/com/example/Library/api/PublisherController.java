package com.example.Library.api;

import com.example.Library.model.Publisher;
import com.example.Library.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/Publisher")
@RestController
@RequiredArgsConstructor
public class PublisherController {
    private final PublisherService publisherService;

    @PostMapping
    public ResponseEntity<Publisher> addPublisher(@RequestBody Publisher publisher){
        return ResponseEntity.ok(publisherService.addPublisher(publisher));
    }

    @GetMapping
    public ResponseEntity<List<Publisher>> getAllPublishers(){
        return ResponseEntity.ok(publisherService.getAllPublishers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publisher> getPublisherById(@PathVariable("id") Long id){
        return ResponseEntity.ok(publisherService.getPublisherById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Publisher> updatePublisher(@PathVariable("id") Long id
            , @RequestBody Publisher publisher){

        return ResponseEntity.ok(publisherService.updatePublisher(id, publisher));
    }

    @DeleteMapping("/{id}")
    public void deletePublisher(@PathVariable("id") Long id){
        publisherService.deletePublisher(id);
    }
}
