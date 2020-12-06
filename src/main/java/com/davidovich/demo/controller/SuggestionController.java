package com.davidovich.demo.controller;

import com.davidovich.demo.dto.SuggestionDTO;
import com.davidovich.demo.model.Suggestion;
import com.davidovich.demo.service.SuggestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class SuggestionController {

        private final SuggestionService suggestionService;

        @GetMapping("/suggestions")
        private Iterable<Suggestion> getAllRequests() {
            return suggestionService.getAllRequests();
        }

        @GetMapping("/suggestions/{id}")
        private Suggestion getRequest(@PathVariable("id") int id) {
            return suggestionService.getRequestById(id);
        }

        @DeleteMapping("/suggestions/{id}")
        private void deleteRequest(@PathVariable("id") int id) {
            suggestionService.delete(id);
        }

        @PostMapping("/suggestions")
        private int savePerson(@RequestBody SuggestionDTO suggestionDTO) {
          Suggestion suggestion = new Suggestion(suggestionDTO.getRequest(),
                    suggestionDTO.getLocal_date_time(),
                    suggestionDTO.getIndex(),
                    suggestionDTO.getRegion(),
                    suggestionDTO.getCity(),
                    suggestionDTO.getSettlement(),
                    suggestionDTO.getStreet(),
                    suggestionDTO.getHouse()
            );
          Suggestion result = suggestionService.saveOrUpdate(suggestion);
            return result.getId();
        }
}
