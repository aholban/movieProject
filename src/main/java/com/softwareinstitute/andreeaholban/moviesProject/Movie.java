package com.softwareinstitute.andreeaholban.moviesProject;

public class Movie {

    ///////////////////////////////////////////Attributes//////////////////////////////////////////////////////////////////////
    private String title;
    private double rating;
    private int length;


    ///////////////////////////////////////////Constructors////////////////////////////////////////////////////////////////////
    public Movie(String title){
        this.title = title;
    }

    public Movie(String title, int length){
        this.title = title;
        this.length = length;
    }

    //////////////////////////////////////////////Methods/////////////////////////////////////////////////////////////////////


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getJasonObjectOfMovie(){
        return  "{"+
                "\"title\" : \"" + title + "\"" +
                "}";
    }
}
