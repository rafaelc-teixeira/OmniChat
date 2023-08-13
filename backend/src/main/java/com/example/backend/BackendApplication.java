package com.example.backend;

import com.example.backend.model.ChatMessage;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import reactor.core.Disposable;

@SpringBootApplication
public class BackendApplication {

	Logger logger = LoggerFactory.getLogger(BackendApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	ApplicationRunner onStart(ReactiveMongoTemplate template) {

		return args -> {

			CollectionOptions options = CollectionOptions.empty()
					.capped().size(5000000)
					.maxDocuments(10000);

			try {
				Disposable result = template.createCollection(ChatMessage.class, options).subscribe();
				result.dispose();
			} catch (Exception e) {
				logger.info(e.getMessage());
			}

		};
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
