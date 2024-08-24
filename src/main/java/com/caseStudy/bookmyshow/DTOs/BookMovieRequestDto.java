package com.caseStudy.bookmyshow.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class BookMovieRequestDto {

     private List<Long> ShowSeatsIds;
     private Long userId;
     private Long showId;


}
