package com.db.assignment.Trade.Store;

import lombok.extern.slf4j.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.*;

@SpringBootApplication
@Slf4j
@EnableScheduling
public class TradeStoreApplication {

	public static void main(String[] args) {
		log.info("*******************Application started********************************");
		SpringApplication.run(TradeStoreApplication.class, args);
	}

}
