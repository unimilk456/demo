package com.davidovich.demo.controller;


import com.davidovich.demo.dto.AddressQueryDTO;
import com.davidovich.demo.dto.DadaDTO;
import com.davidovich.demo.model.Request;
import com.davidovich.demo.service.DadaService;
import com.davidovich.demo.service.MapperObjectToJSONService;
import com.davidovich.demo.service.RequestService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class AddressController {
    final private DadaService dadaService;
    final private MapperObjectToJSONService mapperObjectToJSONService;
    final private RequestService requestService;

    @PostMapping("/address")
    public ResponseEntity<List<DadaDTO>> callAddress(@RequestBody AddressQueryDTO dto) throws JsonProcessingException {
        List<DadaDTO> data = dadaService.getData(dto);
//        String res = mapperObjectToJSONService.transform(data);
        System.out.println("__________");
//        System.out.println(data);
        data.forEach((dadaDTO) -> {
            Request request = Request.builder()
                    .request(dto.getQuery())
                    .localDateTime(LocalDateTime.now())
                    .index(dadaDTO.getIndex())
                    .region(dadaDTO.getRegion())
                    .city(dadaDTO.getCity())
                    .settlement(dadaDTO.getSettlement())
                    .street(dadaDTO.getStreet())
                    .house(dadaDTO.getHouse())
                    .build();

            requestService.saveOrUpdate(request);
        });
        return ResponseEntity.ok(data);
    }

}