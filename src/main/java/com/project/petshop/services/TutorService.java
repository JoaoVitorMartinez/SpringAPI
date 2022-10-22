package com.project.petshop.services;


import com.project.petshop.models.Pet;
import com.project.petshop.models.Tutor;
import com.project.petshop.repositories.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorService {

    @Autowired
    private TutorRepository repository;

    public Tutor save(Tutor tutor) {
        return repository.save(tutor);
    }

    public List<Tutor> findAll() {
        return repository.findAll();
    }

    public boolean delete(Integer id) {
        return repository.delete(id);
    }

    public Tutor edit(int id, Tutor tutor){
        return repository.edit(id, tutor);
    }
}
