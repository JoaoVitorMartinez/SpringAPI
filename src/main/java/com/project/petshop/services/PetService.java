package com.project.petshop.services;

import com.project.petshop.models.Pet;
import com.project.petshop.models.Tutor;
import com.project.petshop.repositories.PetRepository;
import com.project.petshop.repositories.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository repository;

    public Pet save(Pet pet) {
        return repository.save(pet);
    }

    public List<Pet> findAll() {
        return repository.findAll();
    }

    public Pet edit(int id, Pet pet){
        return repository.edit(id, pet);
    }

    public boolean delete(Integer id) {
        return repository.delete(id);
    }
}
