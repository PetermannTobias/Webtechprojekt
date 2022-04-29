package de.htwberlin.service;

import de.htwberlin.persistence.PersonEntity;
import de.htwberlin.persistence.PersonRepository;
import de.htwberlin.web.api.Person;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll(){
        List<PersonEntity> persons = personRepository.findAll();
        return persons.stream()
                .map(personEntity -> new Person(
                        personEntity.getId(),
                        personEntity.getFirstname(),
                        personEntity.getLastname(),
                        personEntity.isVaccinated()))
                .collect(Collectors.toList());
    }



}
