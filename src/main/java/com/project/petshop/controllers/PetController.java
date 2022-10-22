package com.project.petshop.controllers;

import com.project.petshop.models.Pet;
import com.project.petshop.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pet", name = "Pet")
public class PetController {
    @Autowired
    private PetService service;

    @GetMapping("/")
    public List<Pet> get(){
        return service.findAll();

    }

    @GetMapping("/{id}") //http://localhost:8080/tutor/id?id=15641
    public void getById(@RequestParam int id){
        System.out.println(id);



    }

    @PutMapping("{id}")
    public Pet put(@RequestParam int id, @RequestBody Pet pet){
        return service.edit(id, pet);

    }
    @PostMapping("/")
    public Pet post(@RequestBody Pet pet){
        return service.save(pet);

    }
    @DeleteMapping("/{id}")
    public boolean delete(@RequestParam Integer id){
        return service.delete(id);

    }
}
