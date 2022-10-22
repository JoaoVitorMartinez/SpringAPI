package com.project.petshop.services;

import com.project.petshop.models.Pet;
import com.project.petshop.repositories.PetRepository;
import com.project.petshop.repositories.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;
    @Autowired
    private TutorRepository tutorRepository;

    public Pet save(Pet pet) {
        if (tutorRepository.findById(pet.getTutor().getId()) == null){
            tutorRepository.save(pet.getTutor());
            return petRepository.save(pet);
        }
        pet.setTutor(tutorRepository.findById(pet.getTutor().getId()));
        return petRepository.save(pet);
    }

    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    public Pet edit(int id, Pet pet){

        return petRepository.edit(id, pet, tutorRepository.findById(pet.getTutor().getId()));
    }

    public boolean delete(Integer id) {
        return petRepository.delete(id);
    }
}
