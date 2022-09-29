package br.com.robertasantos.transferapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "br.com.robertasantos.transferapi.repository.*", repositoryImplementationPostfix = "CustomImpl")
@EntityScan(basePackages = "br.com.robertasantos.transferapi.domain")
public class TransferApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransferApiApplication.class, args);
	}

}
