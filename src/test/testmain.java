/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import ObjectHandle.Movie;
import ObjectHandle.MoviesList;
import RecommendHandle.RecommendList;
import RecommendHandle.RecommendList2;
import RecommendHandle.RecommendMapRedure;
import java.util.ArrayList;
/**
 *
 * @author MSI
 */
public class testmain {
    public static void main(String[] args) {
        // TODO code application logic here
        MoviesList ml = new MoviesList();
        
        
     
        
        
        
        
        double [][] map = ml.getGenresMap();
        
        for(int i = 0; i< ml.getNoOfMovie(); i++){
            
            
            for(int j=0; j< ml.MaxNoOfGenres(); j++)
            {
                System.out.print(map[i][j]);
            }      
            System.out.print("\n");
        }
    }
}
