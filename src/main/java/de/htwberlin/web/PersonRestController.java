package de.htwberlin.web;

import de.htwberlin.persistence.PersonRepository;
import de.htwberlin.service.PersonService;
import de.htwberlin.web.api.Person;
import de.htwberlin.web.api.PersonCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonRestController {

    private final PersonService personService;

    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(path = "/api/v1/persons")
    public ResponseEntity<List<Person>> fetchPersons() {
        return ResponseEntity.ok(personService.findAll());
    }

    @GetMapping(path = "/api/v1/persons/{id}")
    public ResponseEntity<Person> fetchPersonById(@PathVariable long id){
        var person = personService.findById(id);
        return person != null? ResponseEntity.ok(person): ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/persons")
    public ResponseEntity<Void> createPerson(@RequestBody PersonCreateRequest request) throws URISyntaxException {
        var person = personService.create(request);
        URI uri = new URI("/api/v1/persons/" + person.getId());
        return ResponseEntity.created(uri).build();
    }

}
