package com.selman.billrec;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan(basePackages = "com.selman.billrec")
@EnableAutoConfiguration
@PropertySources({
		@PropertySource("classpath:application.properties"),
		@PropertySource("classpath:auth0.properties")
})
@EnableJSONDoc
public class ListBillApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListBillApplication.class, args);
	}
}
