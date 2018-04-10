/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectHandle;

import java.util.ArrayList;
import java.util.Arrays;


/**
 *
 * @author MSI
 */
public class Movie{
    private String MovieId;
    private String Title;
    private String GenresString;

    public int getNoOfGenres() {
        int no=0;
        ArrayList<String> l = new ArrayList<>();
        String [] genres = this.GenresString.split("\\|");
        for (String i: genres){
            no++;
        }
        return no;
    }

    public Movie() {
    }

    public Movie(String MovieId, String Title, String GenresString) {
        this.MovieId = MovieId;
        this.Title = Title;
        this.GenresString = GenresString;
    }

    public String getMovieId() {
        return MovieId;
    }

    public void setMovieId(String MovieId) {
        this.MovieId = MovieId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getGenresString() {
        return GenresString;
    }

    public void setGenresString(String GenresString) {
        this.GenresString = GenresString;
    }

    /**
     *
     * @return 
     */
    public ArrayList<String> getGenres() {
        ArrayList<String> l = new ArrayList<>();
        String [] genres = this.GenresString.split("\\|");
        for (String i: genres){
            l.add(i);
        }
        return l;
    }
    
    public double getDistance(Movie m){
        double d =0;
        for (String s: this.getGenres())
        {
            if(m.GenresString.contains(s))
            {
                d=d+1;
            }
        }
        double maxsqrd = ((this.getNoOfGenres()>m.getNoOfGenres()? (this.getNoOfGenres()):(m.getNoOfGenres())));
        return Math.sqrt(maxsqrd -d);
    }
    
    public double getDistance(ArrayList<Movie> ms){
        double totalnoofcentergenres = 0;
        double d =0;
        for (Movie m : ms){
            totalnoofcentergenres+= m.getNoOfGenres();
            for (String s: this.getGenres())
            {
                if(m.GenresString.contains(s))
                {
                    d=d+1;
                }
            }
        }
        double maxsqrd = ((this.getNoOfGenres()>totalnoofcentergenres? (this.getNoOfGenres()):(totalnoofcentergenres)));
        return Math.sqrt(maxsqrd -d);
    }
    
    @Override
    public String toString(){
        return "MovieID: "+ this.getMovieId() +", Title: "+ this.getTitle()+", Genres: " +this.getGenresString();
    }
}
