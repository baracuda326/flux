package com.example.demo.service;

import com.example.demo.model.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonService {
    Flux<Person> getAll();

    Mono<Person> getById(String id);

    Mono update(String id, Person person);

    Mono save(Person person);

    Mono delete(String id);
}
