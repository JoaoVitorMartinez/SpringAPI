package com.project.petshop.repositories;

import com.project.petshop.models.Pet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PetRepository {
    private static List<Pet> pets = new ArrayList<>();
    private static int id = 0;

    public List<Pet> findAll() {
        return pets;
    }

    public boolean delete(Integer id) {
        if (findById(id) != null) {
            pets.remove(findById(id));
            return true;
        }
        return false;
    }

    public Pet findById(Integer id) {
        for (Pet pet :
                pets) {
            if (id == pet.getId()) {
                return pet;
            }

        }
        return null;
    }

    public Pet save(Pet pet) {
        if (null == pet.getId()) {
            pet.setId(generatedId());
            pets.add(pet);
            return pet;

        }

        Pet petEditacao = findById(pet.getId());
        petEditacao.setNome(pet.getNome());
        petEditacao.setRaca(pet.getRaca());

        return petEditacao;
    }

    private Integer generatedId() {

        return ++this.id;
    }

    public Pet edit(int id, Pet pet) {
        if (findById(id) != null){
            Pet petEdicao = findById(id);
            petEdicao.setNome(pet.getNome());
            petEdicao.setRaca(pet.getRaca());

            return petEdicao;
        }

        return null;

    }
}
