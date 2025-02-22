package com.caseStudy.bookmyshow.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel {
     private int refNumber;
     private int amount;
     @Enumerated(EnumType.ORDINAL)
     private PaymentProvider paymentProvider;
     @Enumerated(EnumType.ORDINAL)
     private PaymentStatus paymentStatus;
}
