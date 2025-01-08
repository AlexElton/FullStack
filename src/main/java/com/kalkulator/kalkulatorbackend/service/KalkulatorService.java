package com.kalkulator.kalkulatorbackend.service;

import com.kalkulator.kalkulatorbackend.model.KalkulatorRequest;
import org.springframework.stereotype.Service;

@Service
public class KalkulatorService {

  public double calculate(KalkulatorRequest request) {
    double operand1 = request.getOperand1();
    double operand2 = request.getOperand2();
    String operator = request.getOperator();

    return switch (operator) {
      case "+" -> operand1 + operand2;
      case "-" -> operand1 - operand2;
      case "*" -> operand1 * operand2;
      case "/" -> {
        if (operand2 == 0) {
          throw new IllegalArgumentException("Kan ikke dele på 0");
        }
        yield operand1 / operand2;
      }
      default -> throw new IllegalArgumentException("Ugyldig operator: " + operator);
    };
  }
}
