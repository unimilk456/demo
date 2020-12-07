package com.davidovich.demo.service;

import com.davidovich.demo.dto.AddressQueryDTO;
import com.davidovich.demo.dto.DadaDTO;
import com.davidovich.demo.model.Suggestion;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class SuggestionFacadeService {

  final private DadaService dadaService;
  final private MapperObjectToJSONService mapperObjectToJSONService;
  final private SuggestionService suggestionService;

  public List<DadaDTO> getData(AddressQueryDTO dto) throws JsonProcessingException {

    //check db
    List<DadaDTO> dtos = suggestionService.getSuggestionFromDb(dto);

    // if exist in db -> from db
    if (dtos.size() > 0) {
      log.info("Returned suggestions from db {}", dtos);
      return dtos;
    }

    //else make call to dada
    List<DadaDTO> data = dadaService.getData(dto);
//        String res = mapperObjectToJSONService.transform(data);
    System.out.println("__________");
//        System.out.println(data);
    LocalDateTime localDateTime = LocalDateTime.now();

    data.forEach((dadaDTO) -> {
      Suggestion request = Suggestion.builder()
          .request(dto.getQuery())
          .localDateTime(localDateTime)
          .index(dadaDTO.getIndex())
          .region(dadaDTO.getRegion())
          .city(dadaDTO.getCity())
          .settlement(dadaDTO.getSettlement())
          .street(dadaDTO.getStreet())
          .house(dadaDTO.getHouse())
          .build();

      suggestionService.saveOrUpdate(request);
    });
    log.info("Returned suggestions from dada service {}", data);

    return data;
  }
}
