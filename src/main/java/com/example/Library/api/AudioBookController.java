package com.example.Library.api;

import com.example.Library.dto.AudioBookRequest;
import com.example.Library.model.AudioBook;
import com.example.Library.service.AudioBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/AudioBook")
@RestController
@RequiredArgsConstructor
public class AudioBookController {
    private final AudioBookService audioBookService;

    @PostMapping
    public ResponseEntity<AudioBook> addAudioBook(@RequestBody AudioBookRequest audioBookRequest){
        return ResponseEntity.ok(audioBookService.addAudioBook(audioBookRequest));
    }

    @GetMapping
    public ResponseEntity<List<AudioBook>> getAllAudioBooks(){
        return ResponseEntity.ok(audioBookService.getAllAudioBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AudioBook> getAudioBookById(@PathVariable("id") Long id){
        return ResponseEntity.ok(audioBookService.getAudioBookById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AudioBook> updateAudioBook(@PathVariable("id") Long id
            , @RequestBody AudioBookRequest audioBookRequest){

        return ResponseEntity.ok(audioBookService.updateAudioBook(id, audioBookRequest));
    }

    @DeleteMapping("/{id}")
    public void deleteAudioBook(@PathVariable("id") Long id){
        audioBookService.deleteAudioBook(id);
    }
}
