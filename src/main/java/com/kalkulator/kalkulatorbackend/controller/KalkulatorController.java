package com.kalkulator.kalkulatorbackend.controller;
import com.kalkulator.kalkulatorbackend.model.KalkulatorRequest;
import com.kalkulator.kalkulatorbackend.model.KalkulatorResponse;
import com.kalkulator.kalkulatorbackend.service.KalkulatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class KalkulatorController {
  private final KalkulatorService kalkulatorService;
  private static final Logger logger = LoggerFactory.getLogger(KalkulatorController.class);

  public KalkulatorController(KalkulatorService kalkulatorService) {
    this.kalkulatorService = kalkulatorService;
  }


}
