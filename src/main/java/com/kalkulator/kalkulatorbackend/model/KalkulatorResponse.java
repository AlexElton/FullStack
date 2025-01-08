package com.kalkulator.kalkulatorbackend.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class KalkulatorResponse {
  private double result;
  private String message;

  public KalkulatorResponse(double result, String message) {
    this.result = result;
    this.message = message;
  }

  public double getResult () {
    return result;
  }

  public String getMessage () {
    return message;
  }

}
