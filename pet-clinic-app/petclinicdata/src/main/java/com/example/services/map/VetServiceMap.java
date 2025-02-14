package com.example.services.map;
import java.util.Set;
import com.example.model.Vet;
import com.example.services.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }
    @Override
    public void deleteById(Long id) {}
    @Override
    public void delete(Vet owner) {}
    @Override
    public Vet save(Vet object) {
        return super.save(object);
    }
    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
