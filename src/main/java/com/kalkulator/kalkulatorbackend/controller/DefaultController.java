package com.kalkulator.kalkulatorbackend.controller;

import com.kalkulator.kalkulatorbackend.model.KalkulatorRequest;
import com.kalkulator.kalkulatorbackend.model.KalkulatorResponse;
import com.kalkulator.kalkulatorbackend.service.KalkulatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {
  private final KalkulatorService kalkulatorService;
  private static final Logger logger = LoggerFactory.getLogger(DefaultController.class);

  public DefaultController(KalkulatorService kalkulatorService) {
    this.kalkulatorService = kalkulatorService;
  }

  @GetMapping("/")
  public ResponseEntity<KalkulatorResponse> calculateGet(
      @RequestParam(defaultValue = "1") double value1,
      @RequestParam(defaultValue = "2") double value2,
      @RequestParam(defaultValue = "+") String operation
  ) {
    logger.info("Request: value1={}, value2={}, operation={}", value1, value2, operation);
    try {
      // Create a KalkulatorRequest object from the query parameters
      KalkulatorRequest request = new KalkulatorRequest(value1, value2, operation);
      double resultat = kalkulatorService.calculate(request);
      return ResponseEntity.ok(new KalkulatorResponse(resultat, "Kalkulasjon vellykket."));
    } catch (IllegalArgumentException e) {
      logger.error("Feil under kalkulasjon: {}", e.getMessage());
      return ResponseEntity.badRequest().body(new KalkulatorResponse(0, e.getMessage()));
    }
  }

}