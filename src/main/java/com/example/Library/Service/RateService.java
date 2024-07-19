package com.example.Library.Service;

import com.example.Library.DTO.RateRequest;
import com.example.Library.Exeption.ResourceNotFound;
import com.example.Library.Model.Book;
import com.example.Library.Model.Rate;
import com.example.Library.Model.User;
import com.example.Library.Repository.BookRepository;
import com.example.Library.Repository.RateRepository;
import com.example.Library.Repository.UserRepository;
import com.sun.jdi.request.BreakpointRequest;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
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
