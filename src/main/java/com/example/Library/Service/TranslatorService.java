package com.example.Library.Service;

import com.example.Library.Exeption.ResourceNotFound;
import com.example.Library.Model.Translator;
import com.example.Library.Repository.TranslatorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TranslatorService {
    private final TranslatorRepository translatorRepository;

    public List<Translator> getAllTranslators(){
        return translatorRepository.findAll();
    }

    public Translator getTranslatorById(Long id){
        return translatorRepository.findById(id).orElseThrow(ResourceNotFound.instance("Translator not found"));
    }

    public Translator addTranslator(Translator translator){
        return translatorRepository.save(translator);
    }

    public Translator updateTranslator(Long id, Translator updatedTranslator){
        Translator translator = getTranslatorById(id);

        translator.setName(updatedTranslator.getName());
        translator.setAbout(updatedTranslator.getAbout());
        return translatorRepository.save(translator);
    }

    public void deleteTranslator(Long id){
        Translator translator = getTranslatorById(id);
        translatorRepository.delete(translator);
    }
}
