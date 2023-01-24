package com.example.demo.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="filiere")
@Getter
@Setter
public class Filiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="filiere_id")
    private Long filiereId;


    @Column(name="nom")
    private String nom;
}
