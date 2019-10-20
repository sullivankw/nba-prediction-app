package com.sullivankw.NBAWinTotalsPredictor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NbaWinTotalsPredictorApplication {

	public static void main(String[] args) {
		SpringApplication.run(NbaWinTotalsPredictorApplication.class, args);
	}

}
