package com.example.services.map;

import com.example.model.Speciality;
import com.example.services.SpecialitesService;

import java.util.Set;

public class SpecialitesServiceMap extends AbstractMapService<Speciality, Long> implements SpecialitesService {
    @Override
    public Set<Speciality> findAll() { return super.findAll(); }
    @Override
    public void deleteById(Long id) { super.deleteById(id); }
    @Override
    public void delete(Speciality object) { super.delete(object); }
    @Override
    public Speciality save(Speciality object) { return super.save(object); }
    @Override
    public Speciality findById(Long id) { return super.findById(id); }
}
