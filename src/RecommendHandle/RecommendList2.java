/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecommendHandle;

import DataHandle.CsvReader;
import ObjectHandle.Movie;
import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;

/**
 *
 * @author MSI
 */
public class RecommendList2 {
    private ArrayList<Recommend2> list;
    private ArrayList<Movie> centermovies;
    private int NoOfRecommend;

    public RecommendList2(ArrayList<Movie> centermovies) {
        this.centermovies = centermovies;
        CsvReader rd = new CsvReader();
        this.list =new ArrayList<>();
        this.NoOfRecommend = 0;
        rd.GetAllRow().stream().map((i) -> new Recommend2(new Movie(i[0],i[1],i[2]), this.centermovies)).forEachOrdered((Recommend2 r) -> {
            boolean valid = true;
            for (Movie m: r.getCentermovies()){
                if(r.getCurrentmovie().getMovieId().equals(m.getMovieId()))
                {
                    valid = false;
                }
            }
            if(valid){
                list.add(r);
                RecommendList2.this.NoOfRecommend++;
            }
        });      
        this.list.remove(0);
        Collections.sort(this.list);
        this.list.removeIf(s-> this.list.indexOf(s)> 10);
    }

    public ArrayList<Recommend2> getList() {
        return list;
    }

    public ArrayList<Movie> getCentermovies() {
        return centermovies;
    }

    public int getNoOfRecommend() {
        return NoOfRecommend;
    }

    public void setList(ArrayList<Recommend2> list) {
        this.list = list;
    }

    public void setCentermovies(ArrayList<Movie> centermovies) {
        this.centermovies = centermovies;
    }

    public ArrayList<String> getStringList(){
        ArrayList<String> array = new ArrayList<>();
        this.list.forEach((m) -> {
            array.add(m.toString());
        });
        return array;
        
    }
}
