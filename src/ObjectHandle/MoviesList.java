/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectHandle;
import DataHandle.CsvReader;
import java.util.ArrayList;
/**
 *
 * @author MSI
 */
public class MoviesList {
    private ArrayList<Movie> list;
    private ArrayList<String> genresModel;
    private int NoOfMovie;

    public ArrayList<Movie> getList() {
        return list;
    }

    public ArrayList<String> getGenresModel() {
        return genresModel;
    }

    public void setGenresModel(ArrayList<String> genresModel) {
        this.genresModel = genresModel;
    }

    public void setList(ArrayList<Movie> list) {
        this.list = list;
    }

    public int getNoOfMovie() {
        return NoOfMovie;
    }

    public void setNoOfMovie(int NoOfMovie) {
        this.NoOfMovie = NoOfMovie;
    }
    
    public MoviesList() {
        CsvReader rd = new CsvReader();
        this.list =new ArrayList<>();
        this.genresModel = new ArrayList<>();
        this.NoOfMovie = 0;
        rd.GetAllRow().stream().map((i) -> new Movie(i[0],i[1],i[2])).forEachOrdered((m) -> {
            list.add(m);
            this.NoOfMovie++;
            for(String genre : m.getGenres()){
                System.out.print(genre);
                if(!this.genresModel.contains(genre)){
                    this.genresModel.add(genre);
                }
            }
            System.out.println();
        });   
        this.list.remove(0);
    }   
    public int MaxNoOfGenres() {
        int n = 0;
        for(Movie m : this.list)
        {
            if (n< m.getNoOfGenres())
            {
                n= m.getNoOfGenres();
            }
        }       
        return n;
    }   
    public ArrayList<String> getStringList(){
        ArrayList<String> array = new ArrayList<>();
        this.list.forEach((m) -> {
            array.add(m.toString());
        });
        return array;
    }
    
    public double[][] getGenresMap(){
        double [][]map = new double[this.list.size()][this.genresModel.size()];
        int index = 0;
        for (Movie m : this.list){
            double []point =new double[this.genresModel.size()];
            
            for(int i=0; i<point.length; i++){
                if(m.getGenres().contains(this.genresModel.get(i))){
                    point[i]=1;
                }
                else{
                    point[i]=0;
                }
            }
            map[index] = point;
            index++;
        }
        
        return map;
    }
}
