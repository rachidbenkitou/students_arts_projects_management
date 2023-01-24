package com.example.demo.entity;




import lombok.Getter;
import lombok.Setter;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(name = "nom_user")
    private String nom_user;

    @Column(name = "prenom_user")
    private  String prenom_user;

    private String username;
    private String password;
    private boolean enabled;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    public String isActive(){
        String status="";

        if(enabled) status="Active";
        else status="Inactive";
        return status;
    }

}
