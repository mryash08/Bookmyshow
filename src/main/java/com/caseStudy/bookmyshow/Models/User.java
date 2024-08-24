package com.caseStudy.bookmyshow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class User extends BaseModel{

    private String Name;
    private String Email;
    @OneToMany
    private List<Booking> bookings;
    private String password;
}
