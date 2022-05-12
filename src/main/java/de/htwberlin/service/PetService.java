package de.htwberlin.service;

import de.htwberlin.persistence.Gender;
import de.htwberlin.persistence.PetEntity;
import de.htwberlin.persistence.PetRepository;
import de.htwberlin.web.api.Pet;
import de.htwberlin.web.api.PetManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<Pet> findAll() {
        List<PetEntity> pets = petRepository.findAll();
        return pets.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Pet create(PetManipulationRequest request) {
        var gender = Gender.valueOf(request.getGender());

        var petEntity = new PetEntity(request.getName(),gender);
        petEntity = petRepository.save(petEntity);
        return  transformEntity(petEntity);
    }

    private Pet transformEntity(PetEntity petEntity){
        var gender = petEntity.getGender() !=null ? petEntity.getGender().name() : Gender.UNKNOWN.name();
        return new Pet(
                petEntity.getId(),
                petEntity.getName(),
                gender
        );
    }
}
