package com.bank.opening.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.bank.opening.accounts")
@EnableJpaRepositories(basePackages = "com.bank.opening.accounts.repository")
@EntityScan("com.bank.opening.accounts.model")
public class ProjectOpeningAccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectOpeningAccountsApplication.class, args);
	}

}
