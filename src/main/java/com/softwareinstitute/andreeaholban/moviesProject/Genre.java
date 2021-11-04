package com.softwareinstitute.andreeaholban.moviesProject;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "category")
public class Genre {
    ////////////////////////////////////////////Attributes//////////////////////////////////////////////////////////////////

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int genreID;

    private String name;

    @ManyToMany(mappedBy = "genres")
    Set<Film> moviesInGenre;

    //////////////////////////////////////////////Constructors///////////////////////////////////////////////////////////////

    public Genre(){

    }

    public Genre(int ID, String name){
        this.genreID = ID;
        this.name = name;
    }

    ////////////////////////////////////////////Methods///////////////////////////////////////////////////////////////////////


    public int getGenreID() {
        return genreID;
    }

    public void setGenreID(int genreID) {
        this.genreID = genreID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
