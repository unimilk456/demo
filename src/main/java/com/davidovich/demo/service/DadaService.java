package com.davidovich.demo.service;

import com.davidovich.demo.model.AddressQueryDTO;
import com.davidovich.demo.model.DadaDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@RequiredArgsConstructor
public class DadaService {

    final private  RestTemplate restTemplate;
    final private  MapperService mapperService;


    public ResponseEntity<DadaDTO> getData (AddressQueryDTO dto) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        headers.set("Content-Type", "application/json");
        headers.set("Authorization", "Token 717792a0f6715fcc0031ab70d378143ccda2733d");

        HttpEntity<AddressQueryDTO> request = new HttpEntity<>(dto, headers);

        String response = restTemplate
                .postForObject("https://suggestions.dadata.ru/suggestions/api/4_1/rs/suggest/address",
                        request,
                        String.class);


        DadaDTO dadaDTO = mapperService.transform(response);

        ResponseEntity<DadaDTO> responseFor = ResponseEntity.ok(dadaDTO);

        return responseFor;
    }
}