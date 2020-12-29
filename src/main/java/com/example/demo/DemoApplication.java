package com.example.demo;

import com.example.demo.model.Person;
import com.example.demo.model.Sex;
import com.example.demo.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import reactor.core.publisher.Flux;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @Bean
    CommandLineRunner run(PersonRepository personRepository) {
        return args -> {
            personRepository.deleteAll()
                    .thenMany(Flux.just(
                            new Person("1", Sex.MAN, "Kirill", "Sereda", "30", "programming"),
                            new Person("2", Sex.MAN, "Mike", "Nikson", "28", "music"),
                            new Person("3", Sex.MAN, "Oliver", "Spenser", "33", "sport"),
                            new Person("4", Sex.WOMEN, "Olga", "Ivanova", "25", "movie"),
                            new Person("5", Sex.WOMEN, "Anna", "Karenina", "23", "dance"),
                            new Person("6", Sex.WOMEN, "Olga", "Petrova", "27", "programming")

                    )
                            .flatMap(personRepository::save))
                    .thenMany(personRepository.findAll())
                    .subscribe(System.out::println);

        };
    }
}
