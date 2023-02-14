package com.GTB.msordereventsconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class MsOrderEventsConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsOrderEventsConsumerApplication.class, args);
	}

}
