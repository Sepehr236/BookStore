package com.example.Library.service;

import com.example.Library.dto.RateRequest;
import com.example.Library.exeption.ResourceNotFound;
import com.example.Library.model.Book;
import com.example.Library.model.Rate;
import com.example.Library.model.User;
import com.example.Library.repository.BookRepository;
import com.example.Library.repository.RateRepository;
import com.example.Library.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class RateService {
    private final RateRepository rateRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public Integer numberOfFiveStars(){
        return rateRepository.fiveStars();
    }
    public Integer numberOfFourStars(){
        return rateRepository.fourStars();
    }
    public Integer numberOfThreeStars(){
        return rateRepository.threeStars();
    }
    public Integer numberOfTwoStars(){
        return rateRepository.twoStars();
    }
    public Integer numberOfOneStars(){
        return rateRepository.oneStars();
    }
    public Integer numberOfRates(){
        return rateRepository.numberOfRates();
    }

    public Double overAllRate(){
        return ((numberOfFiveStars()* 5.0 +
                numberOfFourStars()* 4.0 +
                numberOfThreeStars()* 3.0 +
                numberOfTwoStars()* 2.0 +
                numberOfOneStars()) / numberOfRates());
    }

    public Rate rateBook(RateRequest rateRequest){
        Book book = bookRepository.findById(rateRequest.getBookId())
                .orElseThrow(ResourceNotFound.instance("Book not found !!!"));

        User user = userRepository.findById(rateRequest.getUserId())
                .orElseThrow(ResourceNotFound.instance("User not found !!!"));

        Integer rate = rateRequest.getRate();
        switch(rate){
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
            default:
                throw ResourceNotFound.instance("This rate is not authorised !!!");
        }

        book.setOverAllRate(overAllRate());

        Rate finalrate =rateRepository.save(Rate.builder()
                        .rate(rateRequest.getRate())
                .build());

        user.getRates().add(finalrate);
        book.getRates().add(finalrate);

        return finalrate;
    }
}
