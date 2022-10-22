package com.project.petshop.controllers;

import com.project.petshop.models.Pet;
import com.project.petshop.models.Tutor;
import com.project.petshop.services.PetService;
import com.project.petshop.services.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tutor", name = "Tutor")
public class TutorController {
    @Autowired
    private TutorService service;

    @GetMapping("/")
    public List<Tutor> get(){
        return service.findAll();

    }

    @GetMapping("/{id}") //http://localhost:8080/tutor/id?id=15641
    public void getById(@RequestParam int id){
        System.out.println(id);



    }

    @PutMapping("/{id}")
    public Tutor put(@RequestParam int id, @RequestBody Tutor tutor){
        return service.edit(id, tutor);

    }
    @PostMapping("/")
    public Tutor post(@RequestBody Tutor tutor){
        return service.save(tutor);

    }
    @DeleteMapping("/{id}")
    public boolean delete(@RequestParam Integer id){
        return service.delete(id);

    }

}
