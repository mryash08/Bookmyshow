package com.caseStudy.bookmyshow.Controller;

import com.caseStudy.bookmyshow.DTOs.BookMovieRequestDto;
import com.caseStudy.bookmyshow.DTOs.BookMovieResponseDto;
import com.caseStudy.bookmyshow.DTOs.ResponseStatus;
import com.caseStudy.bookmyshow.Models.Booking;
import com.caseStudy.bookmyshow.Repository.UserRepository;
import com.caseStudy.bookmyshow.Services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Controller
public class BookingController {

   private BookingService bookingService;

   @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public BookMovieResponseDto bookMovie(BookMovieRequestDto bookMovieRequestDto){
         BookMovieResponseDto bookMovieResponseDto = new BookMovieResponseDto();

        Booking booking;

        try {
            booking = bookingService.bookMovie(bookMovieRequestDto.getUserId(),bookMovieRequestDto.getShowSeatsIds(),
                                            bookMovieRequestDto.getShowId());
            bookMovieResponseDto.setBookingId(booking.getId());
            bookMovieResponseDto.setAmount(booking.getAmount());
            bookMovieResponseDto.setStatus(ResponseStatus.SUCCESS);
        }catch (Exception e){
             bookMovieResponseDto.setStatus(ResponseStatus.FAILURE);
        }
         return bookMovieResponseDto;
    }
}
