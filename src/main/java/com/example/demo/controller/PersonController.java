package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/persons")
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;

//    @GetMapping("/get_all_persons")
    @GetMapping(value = "get_all_persons", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Person> getAll() {
        return personService.getAll();
    }

    @GetMapping("/getPerson/{id}")
    public Mono<Person> getById(@PathVariable("id") final String id) {
        return personService.getById(id);
    }

    @PutMapping("/updatePerson/{id}")
    public Mono updateById(@PathVariable("id") final String id, @RequestBody final Person person) {
        return personService.update(id, person);
    }

    @PostMapping("/createPerson")
    public Mono save(@RequestBody final Person person) {
        return personService.save(person);
    }

    @DeleteMapping("/deletePerson/{id}")
    public Mono delete(@PathVariable final String id) {
        return personService.delete(id);
    }

}
