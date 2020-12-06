package com.davidovich.demo.service;

import com.davidovich.demo.dto.AddressQueryDTO;
import com.davidovich.demo.dto.DadaDTO;
import com.davidovich.demo.model.Suggestion;
import com.davidovich.demo.repository.SuggestionRepository;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SuggestionService {

    private final SuggestionRepository suggestionRepository;
    private final MapperService mapperService;

    public Iterable<Suggestion> getAllRequests() {
        return suggestionRepository.findAll();
    }

    public Suggestion getRequestById(int id) {
        return suggestionRepository.findById(id).get();
    }

    public Suggestion saveOrUpdate(Suggestion suggestion) {
        return suggestionRepository.save(suggestion);
    }

    public void delete(int id) {
        suggestionRepository.deleteById(id);
    }

    public List<DadaDTO> getSuggestionFromDb(AddressQueryDTO dto) {
        List<Suggestion> res = suggestionRepository.findByRequestAndDateGreaterThan(dto.getQuery(),
            LocalDateTime.now().minus(3, ChronoUnit.HOURS));
        List<DadaDTO> dtos = mapperService.transform(res);
        return dtos;
    }
}
