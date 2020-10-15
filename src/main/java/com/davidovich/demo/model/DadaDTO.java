package com.davidovich.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DadaDTO {
    private String index;
    private String region;
    private String city;
    private String countrySide;
    private String street;
    private String house;
}
