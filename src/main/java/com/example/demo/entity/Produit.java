package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="produit")
@Getter
@Setter
public class Produit {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;


    @Column(name="numero_prodution")
    private Long numeroProduction;

    @Column(name="code")
    private String code;

    @Column(name="descriptif")
    private String descriptif;

    @Column(name="dimension")
    private String dimension;

    @Column(name="quantite")
    private int quantite;

    @Column(name="prix_unitaire")
    private double prix_unitaire;

    @Column(name="nature")
    private String nature;

    @Column(name="remaruqe")
    private String remarque;

    @Column(name="decision")
    private String decision;

    @Column(name="numero_proces_verbal")
    private String numeroProcesVerbal;

    @Column(name="date_proces_verbal")
    private String dateProcesVerbal;

    @Column(name="numero_don")
    private Long numeroDon;

    @Column(name="date_don")
    private String dateDon;

    @Column(name="receptionnaire_don")
    private String receptionnaireDon;

    @Column(name="numero_affectation")
    private String numeroAffectation;

    @Column(name="date_affectation")
    private String dateAffectation;


    @Column(name="receptionnaire_affectation")
    private String receptionnaireAffectation;


    @Column(name="lieu_affectation")
    private String lieuAffectation;

     private String image;

     private  float poid;

    @ManyToOne
    @JoinColumn(name="filiereId")
    private Filiere filiere;




}
