package com.davidovich.demo.repository;

import com.davidovich.demo.dto.DadaDTO;
import com.davidovich.demo.model.Suggestion;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface SuggestionRepository extends CrudRepository<Suggestion, Integer> {

    @Query(value = "SELECT s FROM Suggestion s WHERE s.request = :query  and s.localDateTime > :ldt")
    List<Suggestion> findByRequestAndDateGreaterThan(String query, LocalDateTime ldt);

    @Transactional
    @Modifying
    @Query(value = "delete from Suggestion s0 where s0.Id in " +
            "(select s.Id from Suggestion s " +
            "where \n" +
            "s.localDateTime < :ldt \n" +
            "and s.request in (\n" +
            "   select s1.request \n" +
            "   from Suggestion s1\n" +
            "   where s1.localDateTime < :ldt " +
            "   group by s1.request  " +
            "   having count(s1.request) >3 ))") // number 3 could be placed as property
    void deleteOlderThen(LocalDateTime ldt);
}


