package com.jpa.mentoria;

import com.jpa.mentoria.entity.Product;
import com.jpa.mentoria.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MentoriaApplication {

	private static final Logger log = LoggerFactory.getLogger(MentoriaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MentoriaApplication.class);
	}

	@Bean
	public CommandLineRunner demo(ProductRepository repository) {

		return (args) -> {

			// save a few products
			repository.save(Product.builder().name("Celular Samsung").price(100.2).build());
			repository.save(Product.builder().name("Tv LG 55 led").price(5000).build());
			repository.save(Product.builder().name("Console PS5").price(4000.6).build());


			// fetch all products
			log.info("Product found with findAll():");
			log.info("-------------------------------");
			repository.findAll().forEach(p -> log.info(p.toString()));

			log.info("");

			// fetch an individual product by ID
			Product product = repository.findById(1L);
			log.info("Product found with findById(1L):");
			log.info("--------------------------------");

			if(product != null)
			log.info(product.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByName("Tv LG 55 led").forEach(bauer -> {
				log.info(bauer.toString());
			});

			log.info("");
			log.info("delete by object");

			Product productDelete = repository.findById(1L);

			repository.delete(productDelete);
			repository.findAll().forEach(p -> log.info(p.toString()));

			log.info("delete by id");
			//repository.deleteById(2L);

			//
			List<Product> byPrice = repository.findByPrice(500.2);

			log.info(Integer.toString(byPrice.size()));
			//log.info(byPrice.size().toString());

		};
	}
}
