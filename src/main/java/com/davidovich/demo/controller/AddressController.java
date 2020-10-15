package com.davidovich.demo.controller;


import com.davidovich.demo.model.AddressQueryDTO;
import com.davidovich.demo.service.DadaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class AddressController {
    final private DadaService dadaService;

    @PostMapping("/address")
    public ResponseEntity<String> callAddress (@RequestBody AddressQueryDTO dto) throws JsonProcessingException {
        dadaService.getData(dto);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        headers.set("Content-Type", "application/json");
        headers.set("Authorization", "Token 717792a0f6715fcc0031ab70d378143ccda2733d");

        HttpEntity<AddressQueryDTO> request = new HttpEntity<>(dto, headers);
        return null;

    }

}
