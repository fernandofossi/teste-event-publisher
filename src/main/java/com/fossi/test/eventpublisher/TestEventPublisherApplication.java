package com.fossi.test.eventpublisher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class TestEventPublisherApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestEventPublisherApplication.class, args);
	}

}
