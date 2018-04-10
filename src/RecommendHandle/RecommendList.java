/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecommendHandle;

import DataHandle.CsvReader;
import ObjectHandle.Movie;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.function.Consumer;

/**
 *
 * @author MSI
 */
public class RecommendList {
    private ArrayList<Recommend> list;
    private Movie centermovie;
    private int NoOfRecommend;

    public RecommendList(Movie centermovie) {
        this.centermovie = centermovie;
        CsvReader rd = new CsvReader();
        this.list =new ArrayList<>();
        this.NoOfRecommend = 0;
        rd.GetAllRow().stream().map((i) -> new Recommend(new Movie(i[0],i[1],i[2]), this.centermovie)).forEachOrdered(new Consumer<Recommend>() {
            @Override
            public void accept(Recommend r) {
                if(!r.getCurrentmovie().getMovieId().equals(r.getCentermovie().getMovieId()))               
                {
                    list.add(r);
                    RecommendList.this.NoOfRecommend++;
                }
            }
        });      
        this.list.remove(0);
        Collections.sort(this.list);
        this.list.removeIf(s-> this.list.indexOf(s)> 10);
    }

    public ArrayList<Recommend> getList() {
        return list;
    }

    public Movie getCentermovie() {
        return centermovie;
    }

    public int getNoOfRecommend() {
        return NoOfRecommend;
    }

    public void setList(ArrayList<Recommend> list) {
        this.list = list;
    }

    public void setCentermovie(Movie centermovie) {
        this.centermovie = centermovie;
    }

    public ArrayList<String> getStringList(){
        ArrayList<String> array = new ArrayList<>();
        this.list.forEach((m) -> {
            array.add(m.toString());
        });
        return array;
        
    }
    
}
