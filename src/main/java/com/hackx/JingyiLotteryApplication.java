package com.hackx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class JingyiLotteryApplication {

	public static void main(String[] args) {
		SpringApplication.run(JingyiLotteryApplication.class, args);
	}
}
