package com.example.Library.service;

import com.example.Library.repository.AudioBookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class AudioBookService {
    private final AudioBookRepository audioBookRepository;
}
