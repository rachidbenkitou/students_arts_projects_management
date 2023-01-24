package com.example.demo.entity;



import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="equipement")
@Getter
@Setter
public class Equipement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="cab")
    private Long cab;

    @Column(name="localisation")
    private String localisation;

    @Column(name="numero_marche")
    private String numeroMarche;

    @Column(name="designation")
    private String designation;

    @Column(name="description")
    private String description;

    @Column(name="marque")
    private String marque;

    @Column(name="puissance")
    private double puissance;

    @Column(name="tension")
    private double tension;

    @Column(name="courant")
    private double courant;

    @Column(name="prix")
    private double prix;

    @Column(name="date_acquisition")
    private String dateAcquisition;

    @Column(name="date_fabriquation")
    private String dateFabriquation;

    @ManyToOne
    @JoinColumn(name="filiereId")
    private Filiere filiere;

}
