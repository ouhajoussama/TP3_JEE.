package com.TP3.customerservice;

import com.TP3.customerservice.entities.Customer;
import com.TP3.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerserviceApplication.class, args);
	}

	@Bean
	CommandLineRunner start (CustomerRepository customerRepository, RepositoryRestConfiguration restConfiguration){
		restConfiguration.exposeIdsFor(Customer.class);
		return args -> {
			customerRepository.save(new Customer(null,"Ouhaj","ouhaj@gmail.com"));
			customerRepository.save(new Customer(null,"LOLO","LOLO@gmail.com"));
			customerRepository.save(new Customer(null,"Soso","soso@gmail.com"));
			customerRepository.findAll().forEach(System.out::println);
		};
	}

}
