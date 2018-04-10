/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecommendHandle;

import ObjectHandle.Movie;
import java.util.ArrayList;

/**
 *
 * @author MSI
 */
public class Recommend2 implements Comparable <Recommend2>{
    private Movie currentmovie;
    private ArrayList<Movie> centermovies;


    public Recommend2(Movie currentmovie, ArrayList<Movie> centermovies) {
        this.currentmovie = currentmovie;
        this.centermovies = centermovies;
    }

    public Recommend2 () {
    }

    public Movie getCurrentmovie() {
        return currentmovie;
    }

    public ArrayList<Movie> getCentermovies() {
        return centermovies;
    }

    public double getDistance() {
        return this.currentmovie.getDistance(centermovies);
    }

    public void setCurrentmovie(Movie currentmovie) {
        this.currentmovie = currentmovie;
    }

    public void setCentermovies(ArrayList<Movie> centermovies) {
        this.centermovies = centermovies;
    }

    @Override
    public int compareTo(Recommend2 t) {
        if (this.getDistance() > t.getDistance()) {
            return 1;
        } else if (this.getDistance() < t.getDistance()) {
            return -1;
        } else {
            return 0;
        }
        
    }
    
   @Override
    public String toString(){
        return this.getCurrentmovie().toString() + ", Value: " +this.getDistance();
    }
    
}
