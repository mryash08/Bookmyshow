package com.caseStudy.bookmyshow.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.PriorityQueue;

@Getter
@Setter
@Entity
public class Booking extends BaseModel{
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;
    @ManyToMany
    private List<ShowSeat> showSeats;
    @ManyToOne
    private User user;
    private Date BookedAt;
    @ManyToOne
    private Show show;
    private int amount;
    @OneToMany
    private List<Payment> payments;


}
