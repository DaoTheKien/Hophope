/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataHandle;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author MSI
 */
public class CsvReader {
    private String csvFile;
    private String line;
    private String cvsSplitBy;

    public CsvReader() {
        csvFile = "movies.csv";
        line = "";
        cvsSplitBy = ",";
    }

    public CsvReader(String csvFile, String line, String cvsSplitBy) {
        this.csvFile = csvFile;
        this.line = line;
        this.cvsSplitBy = cvsSplitBy;
    }

    public String getCsvFile() {
        return csvFile;
    }

    public void setCsvFile(String csvFile) {
        this.csvFile = csvFile;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getCvsSplitBy() {
        return cvsSplitBy;
    }

    public void setCvsSplitBy(String cvsSplitBy) {
        this.cvsSplitBy = cvsSplitBy;
    }
    public ArrayList<String> GetColunm(int i){
        
        ArrayList<String> array =new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] movie = line.split(cvsSplitBy);
                /// push item
                array.add(movie[i]);
                
            }
        } catch (IOException e) {
        }
        return array;
    }
    public ArrayList<String[]> GetAllRow(){
        
        ArrayList<String[]> array =new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] movie = line.split(cvsSplitBy);
                if(movie.length>3){
                    movie[0] =line.split(",\"")[0];
                    movie[1] =line.split(",\"")[1].split("\",")[0];
                    movie[2] =line.split(",\"")[1].split("\",")[1];
                }
                /// push item
                array.add(movie);             
            }
        } catch (IOException e) {
        }
        return array;
    }
}
