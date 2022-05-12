package de.htwberlin.service;

import de.htwberlin.persistence.Gender;
import de.htwberlin.persistence.PersonEntity;
import de.htwberlin.web.api.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonTransformer {

    public Person transformEntity(PersonEntity personEntity){
        var gender = personEntity.getGender() !=null ? personEntity.getGender().name() : Gender.UNKNOWN.name();
        return new Person(
                personEntity.getId(),
                personEntity.getFirstname(),
                personEntity.getLastname(),
                gender,
                personEntity.isVaccinated()
        );
    }
}
