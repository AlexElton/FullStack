package com.kalkulator.kalkulatorbackend;

import com.kalkulator.kalkulatorbackend.model.KalkulatorResponse;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication(scanBasePackages = "com.kalkulator.kalkulatorbackend")
public class KalkulatorBackendApplication {
  public static void main(String[] args) {
    SpringApplication.run(KalkulatorBackendApplication.class, args);
  }
}
