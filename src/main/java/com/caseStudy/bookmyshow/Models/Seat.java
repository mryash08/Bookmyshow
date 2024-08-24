package com.caseStudy.bookmyshow.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{

    private String Number;
    @ManyToOne
    private SeatType seatType;
    private int rowVal;
    private int colVal;
}
