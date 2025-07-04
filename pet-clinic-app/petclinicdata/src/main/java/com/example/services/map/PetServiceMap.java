package com.example.services.map;
import java.util.Set;
import com.example.model.Pet;
import com.example.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({ "default", "map" })
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }
    @Override
    public void deleteById(Long id) {}
    @Override
    public void delete(Pet owner) {}
    @Override
    public Pet save(Pet object) {
        return super.save(object);
    }
    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
