package com.davidovich.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor

public class DadaDTO {
    private String index;
    private String region;
    private String city;
    private String countrySide;
    private String street;
    private String house;
}
