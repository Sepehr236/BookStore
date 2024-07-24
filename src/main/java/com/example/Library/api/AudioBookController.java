package com.example.Library.api;

import com.example.Library.dto.AudioBookRequest;
import com.example.Library.model.AudioBook;
import com.example.Library.service.AudioBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/AudioBook")
@RestController
@RequiredArgsConstructor
public class AudioBookController {
    private final AudioBookService audioBookService;

    @PostMapping
    public ResponseEntity<AudioBook> addAudioBook(@RequestBody AudioBookRequest audioBookRequest){
        return ResponseEntity.ok(audioBookService.addAudioBook(audioBookRequest));
    }
}
