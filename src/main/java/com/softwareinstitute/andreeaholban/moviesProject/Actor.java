package com.softwareinstitute.andreeaholban.moviesProject;


import javax.persistence.*;
import java.util.Set;

@Entity
// @SequenceGenerator(name="seq", initialValue=201)
@Table(name = "actor")
public class Actor {
    /////////////////////////////////////////////////Attributes////////////////////////////////////////////////////////////////
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private int actor_id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToMany(mappedBy = "actorsInMovie")
    Set<Film> movies;

    /////////////////////////////////////////////////Constructors//////////////////////////////////////////////////////////////
    public Actor(){

    }

    public Actor(String first_name, String last_name){
        this.firstName = first_name;
        this.lastName = last_name;
    }

    /////////////////////////////////////////////////Methods///////////////////////////////////////////////////////////////////


    public int getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
