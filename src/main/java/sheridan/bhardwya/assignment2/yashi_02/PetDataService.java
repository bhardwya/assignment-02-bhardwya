package sheridan.bhardwya.assignment2.yashi_02;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetDataService {
    //services
    private final PetRep petRepository;
    @Autowired
    public PetDataService(PetRep petRepository) {

        this.petRepository = petRepository;
    }

    public List<PetData> getAllPets() {

        return petRepository.findAll();
    }



    public PetData getPetData(long id) {
        return petRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid pet Id:" + id));
    }
    public void deletePetData(long id) {

        petRepository.deleteById(id);
    }
    public void addPetData(@Valid PetData pet) {

        petRepository.save(pet);
    }
}

