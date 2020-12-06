package com.davidovich.demo.repository;

import com.davidovich.demo.dto.DadaDTO;
import com.davidovich.demo.model.Suggestion;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SuggestionRepository extends CrudRepository<Suggestion, Integer> {

  @Query(value = "SELECT s FROM Suggestion s WHERE s.request = :query  and s.localDateTime > :ldt")
  List<Suggestion> findByRequestAndDateGreaterThan(String query, LocalDateTime ldt);

  @Query(value = "DELETE FROM Suggestion s WHERE s.localDateTime < :ldt")
  void deleteOlderThen(LocalDateTime ldt);
}


