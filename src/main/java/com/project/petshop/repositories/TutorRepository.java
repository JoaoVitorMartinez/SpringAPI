package com.project.petshop.repositories;


import com.project.petshop.models.Pet;
import com.project.petshop.models.Tutor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TutorRepository {

    private static List<Tutor> tutores = new ArrayList<>();
    private static int id = 0;

    public List<Tutor> findAll() {
        return tutores;
    }

    public boolean delete(int id) {
        if (findById(id) != null) {
            tutores.remove(findById(id));
            return true;
        }
        return false;
    }

    public Tutor findById(Integer id) {
        for (Tutor tutor :
                tutores) {
            if (id == tutor.getId()) {
                return tutor;
            }

        }
        return null;
    }

    public Tutor save(Tutor tutor) {
        if (null == tutor.getId()) {
            tutor.setId(generatedId());
            tutores.add(tutor);
            return tutor;

        }

        Tutor tutorEdicao = findById(tutor.getId());
        tutorEdicao.setNome(tutor.getNome());
        tutorEdicao.setIdade(tutor.getIdade());

        return tutorEdicao;
    }

    public Tutor edit(int id, Tutor tutor) {
        if (findById(id) != null){
            Tutor tutorEdicao = findById(id);
            tutorEdicao.setNome(tutor.getNome());
            tutorEdicao.setIdade(tutor.getIdade());

            return tutorEdicao;
        }

        return null;

    }

    private Integer generatedId() {

        return ++this.id;
    }
}
