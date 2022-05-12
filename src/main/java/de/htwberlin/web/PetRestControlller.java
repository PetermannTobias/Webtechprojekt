package de.htwberlin.web;

import de.htwberlin.service.PetService;
import de.htwberlin.web.api.Pet;
import de.htwberlin.web.api.PetManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class PetRestControlller {

    private final PetService petService;

    public PetRestControlller(PetService petService) {
        this.petService = petService;
    }

    @GetMapping(path = "/api/v1/pets")
    public ResponseEntity<List<Pet>> fetchPets() {
        return ResponseEntity.ok(petService.findAll());
    }

    @PostMapping(path = "/api/v1/pets")
    public ResponseEntity<Void> createPet(@RequestBody PetManipulationRequest request) throws URISyntaxException {
        var pet = petService.create(request);
        URI uri = new URI("/api/v1/pets/" + pet.getId());
        return ResponseEntity.created(uri).build();
    }
}
