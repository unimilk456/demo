package com.davidovich.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Suggestion")
public class Suggestion {

    public Suggestion(String request,  LocalDateTime localDateTime,
                   String index, String region, String city, String settlement, String street, String house) {
        this.request = request;
        this.localDateTime = localDateTime;
        this.index = index;
        this.region = region;
        this.city = city;
        this.settlement = settlement;
        this.street = street;
        this.house = house;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int Id;
    private String request;
    @Column (name="local_date_time")
    private LocalDateTime localDateTime;
    private  String index;
    private  String region;
    private  String city;
    private  String settlement;
    private  String street;
    private  String house;

}


