package com.example.Library.Service;

import com.example.Library.DTO.RateRequest;
import com.example.Library.Exeption.ResourceNotFound;
import com.example.Library.Model.Book;
import com.example.Library.Model.Rate;
import com.example.Library.Repository.BookRepository;
import com.example.Library.Repository.RateRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class RateService {
    private final RateRepository rateRepository;
    private final BookRepository bookRepository;

    public Integer numberOfFiveStarRatings(){
        return rateRepository.fiveStars();
    }

    public Integer numberOfFourStarRatings(){
        return rateRepository.fourStars();
    }

    public Integer numberOfThreeStarRatings(){
        return rateRepository.threeStar();
    }

    public Integer numberOfTwoStarRatings(){
        return rateRepository.twoStars();
    }

    public Integer numberOfOneStarRatings(){
        return rateRepository.oneStars();
    }

    public Double numberOfRates(){
        return rateRepository.numberOfRates();
    }

    public Double overAllRate(){
        Integer fiveStars = numberOfFiveStarRatings();
        Integer fourStars = numberOfFourStarRatings();
        Integer threeStars = numberOfThreeStarRatings();
        Integer twoStars = numberOfTwoStarRatings();
        Integer oneStars = numberOfOneStarRatings();
        Double rates = numberOfRates();

        return (fiveStars + fourStars + threeStars + twoStars + oneStars) / rates;
    }

    public Rate rateBook(RateRequest rateRequest){
        Book book = bookRepository.findById(rateRequest.getBookId())
                .orElseThrow(ResourceNotFound.instance("Book not found !!!"));

        switch (rateRequest.getRate()){
            case 5:
                book.setFiveStars(book.getFiveStars() + 1);
                break;
            case 4:
                book.setFourStars(book.getFourStars() + 1);
                break;
            case 3:
                book.setThreeStars(book.getThreeStars() + 1);
                break;
            case 2:
                book.setTwoStars(book.getTwoStars() + 1);
                break;
            case 1:
                book.setOneStars(book.getOneStars() + 1);
                break;
        }
        book.setOverAllRate(overAllRate());

        return rateRepository.save(Rate.builder()
                        .rate(rateRequest.getRate())
                .build());
    }

    public Rate updateRate(Long id, Integer newRate){
        Rate rate = rateRepository.findById(id).orElseThrow(ResourceNotFound.instance("Rate not found !!!"));
        rate.setRate(newRate);

        return rate;
    }

    public void deleteRate(Long id){
        rateRepository.deleteById(id);
    }
}
