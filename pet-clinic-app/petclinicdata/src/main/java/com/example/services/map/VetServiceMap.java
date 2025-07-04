package com.example.services.map;
import java.util.Set;

import com.example.model.Speciality;
import com.example.model.Vet;
import com.example.services.SpecialityService;
import com.example.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({ "default", "map" })
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

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
        if(object.getSpecialities().size() > 0) {
            object.getSpecialities().forEach(speciality -> {
                if(speciality.getId() == null) {
                    Speciality savedSpecialty = specialityService.save(speciality);
                    speciality.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(object);
    }
    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
