package com.davidovich.demo.controller;


import com.davidovich.demo.model.AddressQueryDTO;
import com.davidovich.demo.model.DadaDTO;
import com.davidovich.demo.model.Request;
import com.davidovich.demo.service.DadaService;
import com.davidovich.demo.service.MapperObjectToJSONService;
import com.davidovich.demo.service.RequestService;
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

import java.util.List;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class AddressController {
    final private DadaService dadaService;
    final private MapperObjectToJSONService mapperObjectToJSONService;
    final private RequestService requestService;

    @PostMapping("/address")
    public ResponseEntity<List<DadaDTO>> callAddress (@RequestBody AddressQueryDTO dto) throws JsonProcessingException {
        List<DadaDTO> data = dadaService.getData(dto);
        String res = mapperObjectToJSONService.transform(data);
        System.out.println(dto);
        res = res.substring(0,253);
        Request request = Request.builder()
                .request(dto.getQuery())
                .outputData(res)
                .build();
        requestService.saveOrUpdate(request);
        return ResponseEntity.ok(data);
    }

}
