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

/**
 *
 * @author MSI
 */
public class RecommendMapRedure {

    private ArrayList<Recommend2> list;
    private ArrayList<Movie> centermovies;
    private int NoOfRecommend;
    private ArrayList<String[]> allmoviestring;

    public RecommendMapRedure(ArrayList<Movie> centermovies) {
        this.centermovies = centermovies;
        this.list = new ArrayList<>();
        this.centermovies = centermovies;
        CsvReader rd = new CsvReader();
        ArrayList<Recommend2> sublist = new ArrayList<>();
        this.NoOfRecommend = 0;
        allmoviestring = rd.GetAllRow();
        allmoviestring.remove(0);
        while (this.NoOfRecommend < this.allmoviestring.size() - 3000) {
            allmoviestring.subList(this.NoOfRecommend, this.NoOfRecommend + 3000).stream().map((i) -> new Recommend2(new Movie(i[0], i[1], i[2]), this.centermovies)).forEachOrdered((Recommend2 r) -> {
                boolean valid = true;
                for (Movie m : r.getCentermovies()) {
                    if (r.getCurrentmovie().getMovieId().equals(m.getMovieId())) {
                        valid = false;
                    }
                }
                if (valid) {
                    sublist.add(r);

                }
            });

            Collections.sort(sublist);
            sublist.removeIf(s -> sublist.indexOf(s) > 10);
            this.list.addAll(sublist);
            sublist.clear();
            RecommendMapRedure.this.NoOfRecommend += 3000;
        }

        allmoviestring.subList(this.NoOfRecommend, allmoviestring.size() - 1).stream().map((i) -> new Recommend2(new Movie(i[0], i[1], i[2]), this.centermovies)).forEachOrdered((Recommend2 r) -> {
            boolean valid = true;
            for (Movie m : r.getCentermovies()) {
                if (r.getCurrentmovie().getMovieId().equals(m.getMovieId())) {
                    valid = false;
                }
            }
            if (valid) {
                sublist.add(r);

            }
        });
        Collections.sort(sublist);
        sublist.removeIf(s -> sublist.indexOf(s) > 10);
        this.list.addAll(sublist);
        sublist.clear();

        Collections.sort(this.list);
        this.list.removeIf(s -> sublist.indexOf(s) > 10);

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

    public ArrayList<String> getStringList() {
        ArrayList<String> array = new ArrayList<>();
        this.list.forEach((m) -> {
            array.add(m.toString());
        });
        return array;
    }
}
