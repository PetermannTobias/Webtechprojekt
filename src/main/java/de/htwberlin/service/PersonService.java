package de.htwberlin.service;

import de.htwberlin.persistence.Gender;
import de.htwberlin.persistence.PersonEntity;
import de.htwberlin.persistence.PersonRepository;
import de.htwberlin.web.api.Person;
import de.htwberlin.web.api.PersonManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonTransformer personTransformer;

    public PersonService(PersonRepository personRepository, PersonTransformer personTransformer) {
        this.personRepository = personRepository;
        this.personTransformer = personTransformer;
    }

    public List<Person> findAll(){
        List<PersonEntity> persons = personRepository.findAll();
        return persons.stream()
                .map(personTransformer::transformEntity)
                .collect(Collectors.toList());
    }

    public Person findById(long id){
        var personEntity = personRepository.findById(id);
        return personEntity.map(personTransformer::transformEntity).orElse(null);
    }

    public Person create(PersonManipulationRequest request) {
        var gender = Gender.valueOf(request.getGender());
        var personEntity = new PersonEntity(request.getFirstname(), request.getLastname(), request.isVaccinated(), gender);
        personEntity = personRepository.save(personEntity);
        return personTransformer.transformEntity(personEntity);
    }

    public Person update(Long id, PersonManipulationRequest request) {
        var personEntityOptional = personRepository.findById(id);
        if(personEntityOptional.isEmpty()){
            return null;
        }

        var personEntity = personEntityOptional.get();
        personEntity.setFirstname(request.getFirstname());
        personEntity.setLastname(request.getLastname());
        personEntity.setVaccinated(request.isVaccinated());
        personEntity.setGender(Gender.valueOf(request.getGender()));
        personEntity = personRepository.save(personEntity);
        return personTransformer.transformEntity(personEntity);
    }

    public boolean deleteById(Long id){
        if (!personRepository.existsById(id)) {
            return false;
        }

        personRepository.deleteById(id);
        return true;
    }


}
