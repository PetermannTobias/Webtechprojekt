package de.htwberlin.service;

import de.htwberlin.persistence.Gender;
import de.htwberlin.persistence.PersonEntity;
import de.htwberlin.web.api.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonTransformer {

    public Person transformEntity(PersonEntity personEntity){
        var gender = personEntity.getGender() !=null ? personEntity.getGender().name() : Gender.UNKNOWN.name();
        var petId = personEntity.getPet() != null ? personEntity.getPet().getId() : null;
        return new Person(
                personEntity.getId(),
                personEntity.getFirstname(),
                personEntity.getLastname(),
                gender,
                personEntity.isVaccinated(),
                petId);
    }
}
