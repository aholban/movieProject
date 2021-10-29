package com.softwareinstitute.andreeaholban.moviesProject;

public class Movie {

    ///////////////////////////////////////////Attributes//////////////////////////////////////////////////////////////////////
    private String title;


    ///////////////////////////////////////////Constructors////////////////////////////////////////////////////////////////////
    public Movie(String title){
        this.title = title;
    }

    //////////////////////////////////////////////Methods/////////////////////////////////////////////////////////////////////


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJasonObjectOfMovie(){
        return  "{"+
                "\"title\" : \"" + title + "\"" +
                "}";
    }
}
