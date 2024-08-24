package com.caseStudy.bookmyshow.Services;

import com.caseStudy.bookmyshow.Models.Show;
import com.caseStudy.bookmyshow.Models.ShowSeat;
import com.caseStudy.bookmyshow.Models.ShowSeatType;
import com.caseStudy.bookmyshow.Repository.ShowSeatRepository;
import com.caseStudy.bookmyshow.Repository.ShowSeatTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PricingService {

    private ShowSeatTypeRepository showSeatTypeRepository;

    @Autowired
    public PricingService(ShowSeatTypeRepository showSeatTypeRepository) {
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    public int calculatePrice(List<ShowSeat> showSeats, Show show){
        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);
         int amount = 0;
        for(ShowSeat showSeat : showSeats ){
            for(ShowSeatType showSeatType : showSeatTypes){
                if(showSeatType.getType().equals(showSeat.getSeat().getSeatType())){
                      amount += showSeatType.getPrice();
                      break;
                }
            }
        }
        return amount;
    }
}
