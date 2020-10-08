package com.davidovich.demo.controller;


import com.davidovich.demo.model.AddressQueryDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/api")
@RestController
public class AddressController {

    private RestTemplate restTemplate;

    public AddressController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/address")
    public ResponseEntity<String> callAddress (@RequestBody AddressQueryDTO dto) {
        System.out.println(dto);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        headers.set("Content-Type", "application/json");
        headers.set("Authorization", "Token 717792a0f6715fcc0031ab70d378143ccda2733d");

        HttpEntity<AddressQueryDTO> request = new HttpEntity<>(dto, headers);

        String response = restTemplate
                .postForObject("https://suggestions.dadata.ru/suggestions/api/4_1/rs/suggest/address",
                        request,
                        String.class);


        return ResponseEntity.ok(response);
    }

}
