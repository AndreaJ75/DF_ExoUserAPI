package com.bnppf.df.upskilling.model;

import javax.persistence.*;

@Entity
@Table(name="_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @Column(name="id")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="fistName")
    private String firstName;
    @Column(name="email")
    private String email;

    public Long getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getEmail(){
        return email;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
