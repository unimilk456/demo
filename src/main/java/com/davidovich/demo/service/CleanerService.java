package com.davidovich.demo.service;

import com.davidovich.demo.repository.SuggestionRepository;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class CleanerService {

  private final SuggestionRepository suggestionRepository;

  @Scheduled(cron = "* */5 * * * ?")
  public void clean() {
    log.info("Starting cleaning...");
    suggestionRepository.deleteOlderThen(LocalDateTime.now().minus(1, ChronoUnit.MONTHS));
  }

}
