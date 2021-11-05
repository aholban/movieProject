package com.softwareinstitute.andreeaholban.moviesProject;


import javax.persistence.*;
import java.util.Set;

@Entity
@SequenceGenerator(name="seq", initialValue=201)
@Table(name = "actor")
public class Actor {
    /////////////////////////////////////////////////Attributes////////////////////////////////////////////////////////////////
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    private int actor_id;

    private String first_name;
    private String last_name;

    @ManyToMany(mappedBy = "actorsInMovie")
    Set<Film> movies;

    /////////////////////////////////////////////////Constructors//////////////////////////////////////////////////////////////
    public Actor(){

    }

    public Actor(String first_name, String last_name){
        this.first_name = first_name;
        this.last_name = last_name;
    }

    /////////////////////////////////////////////////Methods///////////////////////////////////////////////////////////////////


    public int getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}