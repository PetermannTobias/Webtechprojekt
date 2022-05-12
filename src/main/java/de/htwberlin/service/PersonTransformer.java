package de.htwberlin.service;

import de.htwberlin.persistence.Gender;
import de.htwberlin.persistence.PersonEntity;
import de.htwberlin.persistence.PetEntity;
import de.htwberlin.web.api.Person;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class PersonTransformer {

    public Person transformEntity(PersonEntity personEntity){
        var gender = personEntity.getGender() !=null ? personEntity.getGender().name() : Gender.UNKNOWN.name();
        var petIds = personEntity.getPets().stream().map(PetEntity::getId).collect(Collectors.toList());
        return new Person(
                personEntity.getId(),
                personEntity.getFirstname(),
                personEntity.getLastname(),
                gender,
                personEntity.isVaccinated(),
                petIds);
    }
}
