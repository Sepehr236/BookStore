package com.example.Library.Service;

import com.example.Library.DTO.RateRequest;
import com.example.Library.Model.Rate;
import com.example.Library.Repository.RateRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class RateService {
    private final RateRepository rateRepository;
}
