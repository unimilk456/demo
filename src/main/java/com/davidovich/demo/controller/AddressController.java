package com.davidovich.demo.controller;


import com.davidovich.demo.dto.AddressQueryDTO;
import com.davidovich.demo.dto.DadaDTO;
import com.davidovich.demo.service.SuggestionFacadeService;
import com.davidovich.demo.service.SuggestionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class AddressController {

    final private SuggestionFacadeService suggestionService;

    @PostMapping("/address")
    public ResponseEntity<List<DadaDTO>> callAddress(@RequestBody AddressQueryDTO dto)
        throws JsonProcessingException {
        return ResponseEntity.ok(suggestionService.getData(dto));
    }

}
