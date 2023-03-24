package com.driver;


import com.driver.Director;
import com.driver.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MovieRepository {
    private HashMap<Director,List<Movie>> hm = new HashMap<>();
    private List<Movie> listMovie = new ArrayList<>();//list of Movies
    private List<Director> listDirector = new ArrayList<>();//list of Doctor

    public List<Movie> getListMovieList(){
        return listMovie;
    }
    public List<Director> getListDirector(){
        return listDirector;
    }
    public void addMovie(Movie m){
        listMovie.add(m);
    }
    public void addDirector(Director director){
        listDirector.add(director);
    }
    public Director getDirectorByName(String name){
        for(Director d : listDirector){
            if(d.getName().equals(name))
                return d;
        }
        return null;
    }
    public Movie getMovieByName(String name){
        for(Movie m : listMovie){
            if(m.getName().equals(name))
                return m;
        }
        return null;
    }
    public void addPair(Movie m,Director d){
        if(hm.containsKey(d)) {
            List<Movie> movies = hm.get(d);
            movies.add(m);
            hm.put(d,movies);
        }
        else {
            List<Movie> movieList= new ArrayList<>();
            movieList.add(m);
            hm.put(d,movieList);
        }
    }
    public List<String> getListByDir(Director d){
        List<Movie> movieList = hm.get(d);
        List<String> list  = new ArrayList<>();
        for(Movie m: movieList ){
            list.add(m.getName());
        }
        return list;
    }
    public void deleteDirector(Director director){
        hm.remove(director);
    }
    public void deleteAll(){
        hm.clear();
    }
}