package com.softwareinstitute.andreeaholban.moviesProject;

import javax.persistence.*;

@Entity
@Table(name = "film")
public class Film {

    ///////////////////////////////////////////Attributes//////////////////////////////////////////////////////////////////////


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer film_id;

    private String title;
    private double star_rating;
    private int length;


    ///////////////////////////////////////////Constructors////////////////////////////////////////////////////////////////////
    public Film(String title){
        this.title = title;
    }

    public Film(String title, int length){
        this.title = title;
        this.length = length;
    }

    public Film(){

    }

    //////////////////////////////////////////////Methods/////////////////////////////////////////////////////////////////////


    public Integer getId() {
        return film_id;
    }

    public void setId(Integer id) {
        this.film_id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getStar_rating() {
        return star_rating;
    }

    public void setStar_rating(double rating) {
        this.star_rating = rating;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

}
