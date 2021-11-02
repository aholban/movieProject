package com.softwareinstitute.andreeaholban.moviesProject;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="seq", initialValue=1001, allocationSize=100)
@Table(name = "film")
public class Film {

    ///////////////////////////////////////////Attributes//////////////////////////////////////////////////////////////////////


    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    private Integer film_id;

    private String title;
    private String description;
    private double star_rating;
    private int length;
    private String release_year;
    private int language_id = 1;


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


    public Integer getFilm_id() {
        return film_id;
    }

    public void setFilm_id(Integer id) {
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

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRelease_year() {
        return release_year;
    }

    public void setRelease_year(String release_year) {
        this.release_year = release_year;
    }


}
