package com.example.Library.api;

import com.example.Library.model.Translator;
import com.example.Library.service.TranslatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/Translator")
@RestController
@RequiredArgsConstructor

public class TranslatorController {
    private final TranslatorService translatorService;

    @PostMapping
    public ResponseEntity<Translator> addTranslator(@RequestBody Translator translator){
        return ResponseEntity.ok(translatorService.addTranslator(translator));
    }

    @GetMapping
    public ResponseEntity<List<Translator>> getAllTranslators(){
        return ResponseEntity.ok(translatorService.getAllTranslators());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Translator> getTranslatorById(@PathVariable("id") Long id){
        return  ResponseEntity.ok(translatorService.getTranslatorById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Translator> updateTranslator(@PathVariable("id") Long id
            , @RequestBody Translator translator){

        return ResponseEntity.ok(translatorService.updateTranslator(id, translator));
    }

    @DeleteMapping("/{id}")
    public void deleteTranslator(@PathVariable("id") Long id){
        translatorService.deleteTranslator(id);
    }
}
