package com.davidovich.demo.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Data
public class RequestDTO {
    private final String request;
    private final LocalDateTime local_date_time;
    private final String index;
    private final String region;
    private final String city;
    private final String settlement;
    private final String street;
    private final String house;
}
