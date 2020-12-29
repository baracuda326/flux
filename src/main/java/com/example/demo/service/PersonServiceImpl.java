package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@Transactional
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    @Override
    public Flux<Person> getAll() {
        return personRepository.findAll().delayElements(Duration.ofSeconds(1));
//        return personRepository.findAll().switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<Person> getById(String id) {
        return null;
    }

    @Override
    public Mono update(String id, Person person) {
        return null;
    }

    @Override
    public Mono save(Person person) {
        return null;
    }

    @Override
    public Mono delete(String id) {
        return null;
    }
}
