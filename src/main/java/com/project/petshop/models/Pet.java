package com.project.petshop.models;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@ToString
public class Pet {

    private Integer id;
    private String nome;
    private String raca;
    private Tutor tutor;


    public Pet(Integer id, String nome, String raca) {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
    }

    public Pet(Integer id, String nome, String raca, Tutor tutor) {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.tutor = tutor;
    }
}
