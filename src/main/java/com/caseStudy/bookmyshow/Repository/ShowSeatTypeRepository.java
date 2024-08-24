package com.caseStudy.bookmyshow.Repository;

import com.caseStudy.bookmyshow.Models.Show;
import com.caseStudy.bookmyshow.Models.ShowSeat;
import com.caseStudy.bookmyshow.Models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType,Long> {

    List<ShowSeatType> findAllByShow(Show show);

}
