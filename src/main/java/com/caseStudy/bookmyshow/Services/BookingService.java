package com.caseStudy.bookmyshow.Services;

import com.caseStudy.bookmyshow.Models.*;
import com.caseStudy.bookmyshow.Repository.BookingRepository;
import com.caseStudy.bookmyshow.Repository.ShowRepository;
import com.caseStudy.bookmyshow.Repository.ShowSeatRepository;
import com.caseStudy.bookmyshow.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private PricingService pricingService;
    private BookingRepository bookingRepository;

    @Autowired
    public BookingService(UserRepository userRepository, ShowRepository showRepository, ShowSeatRepository showSeatRepository, PricingService pricingService, BookingRepository bookingRepository) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.pricingService = pricingService;
        this.bookingRepository = bookingRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookMovie(Long userId, List<Long> seatIds,Long ShowId){
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()){
            throw  new RuntimeException();
        }

        User bookedBy = userOptional.get();
        Optional<Show> showOptional = showRepository.findById(ShowId);
        if(showOptional.isEmpty()){
            throw  new RuntimeException();
        }
        Show showBooked = showOptional.get();

        List<ShowSeat> showSeatList = showSeatRepository.findAllById(seatIds);
        for (ShowSeat showSeat : showSeatList){
            if(!(showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE) || (showSeat.getShowSeatStatus().equals(ShowSeatStatus.BLOCKED) &&
                    Duration.between(showSeat.getLockedAt().toInstant(),new Date().toInstant()).toMinutes() > 15))){
                 throw new RuntimeException();
            }
        }
        List<ShowSeat> savedShowList  = new ArrayList<>();
        for(ShowSeat showSeat : showSeatList){
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            showSeat.setLockedAt(new Date());
            savedShowList.add(showSeatRepository.save(showSeat));
        }

        Booking booking  = new Booking();
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setShowSeats(savedShowList);
        booking.setUser(bookedBy);
        booking.setShow(showBooked);
        booking.setBookedAt(new Date());
        booking.setAmount(pricingService.calculatePrice(savedShowList,showBooked));

        Booking savedBooking = bookingRepository.save(booking);


        return  savedBooking;
    }
}
