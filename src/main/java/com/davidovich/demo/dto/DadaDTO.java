package com.davidovich.demo.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DadaDTO {
    private String index;
    private String region;
    private String city;
    private String settlement;
    private String street;
    private String house;
}
