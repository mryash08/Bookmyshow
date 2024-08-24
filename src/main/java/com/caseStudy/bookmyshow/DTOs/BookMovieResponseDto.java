package com.caseStudy.bookmyshow.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookMovieResponseDto {

    private int amount;
    private Long BookingId;
    private ResponseStatus status;

}
