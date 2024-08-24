package com.caseStudy.bookmyshow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.util.StringMap;

import java.util.List;
@Getter
@Setter
@Entity
public class Theatre extends BaseModel{
    private String name;
    @ManyToOne
    private Region region;
    @OneToMany
    private List<Screen> screenList;
}
