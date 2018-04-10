/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecommendHandle;
import ObjectHandle.*;
/**
 *
 * @author MSI
 */
public class Recommend implements Comparable<Recommend>{
   private Movie currentmovie;
   private Movie centermovie;


    public Recommend(Movie currentmovie, Movie centermovie) {
        this.currentmovie = currentmovie;
        this.centermovie = centermovie;
    }

    public Recommend () {
    }

    public Movie getCurrentmovie() {
        return currentmovie;
    }

    public Movie getCentermovie() {
        return centermovie;
    }

    public double getDistance() {
        return this.currentmovie.getDistance(centermovie);
    }

    public void setCurrentmovie(Movie currentmovie) {
        this.currentmovie = currentmovie;
    }

    public void setCentermovie(Movie centermovie) {
        this.centermovie = centermovie;
    }

    @Override
    public int compareTo(Recommend t) {
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
