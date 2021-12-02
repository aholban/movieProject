package com.softwareinstitute.andreeaholban.moviesProject;

import javax.persistence.*;
import java.text.DecimalFormat;
import java.util.Set;

@Entity
//@SequenceGenerator(name="seq", initialValue=1001)
@Table(name = "film")
public class Film {

    ///////////////////////////////////////////Attributes//////////////////////////////////////////////////////////////////////


    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private Integer film_id;

    private String title;
    private String description;
    private double star_rating;
    private int no_ratings;
    private int length;
    private String release_year;
    private int language_id = 1;
    private String videoID;

    @ManyToMany
    @JoinTable(
            name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    Set<Actor> actorsInMovie;

    @ManyToMany
    @JoinTable(
            name = "film_category",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    Set<Genre> genres;

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

    public int getNo_ratings() {
        return no_ratings;
    }

    public void setNo_ratings(int no_ratings){
        this.no_ratings = no_ratings;
    }


    public void updateRating(double new_rating){
        double updatedRating = (star_rating * no_ratings + new_rating)/(no_ratings+1);
        DecimalFormat df = new DecimalFormat("#.##");
        this.star_rating = Double.parseDouble(df.format(updatedRating));
        this.no_ratings = no_ratings + 1;
    }

    public String getVideoID() {
        return videoID;
    }

    public void setVideoID(String videoID) {
        this.videoID = videoID;
    }


}
