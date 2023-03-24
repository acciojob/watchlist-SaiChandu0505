package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MovieRepository {

    HashMap<String,Movie> moviedbs = new HashMap<>();
    HashMap<String, Director> directordbs = new HashMap<>();
    HashMap<String, List<String>> pairdbs = new HashMap<>();

    public String addMovie(Movie movie){

        String key = movie.getName();
        moviedbs.put(key,movie);
        return "Movie added successfully";
    }
    public String addDirector(Director director){

        String key = Director.getName();
        directordbs.put(key,director);
        return "Director added successfully";
    }

    public String addMovieDirectorPair(String movieName, String directorName) {
        if (!moviedbs.containsKey(movieName) || !directordbs.containsKey(directorName)) {
            return "movieName or directorName does not found";
        }
        if (pairdbs.containsKey(directorName)) {
            pairdbs.get(directorName).add(movieName);
        } else {
            List<String> ans = new ArrayList<>();
            ans.add(movieName);
            pairdbs.put(directorName, ans);
        }
        return "director movie pair added successfully";
    }

    public Movie getMovieByName(String name){
        if(!moviedbs.containsKey(name)) return null;
        else{
            return moviedbs.get(name);
        }
    }
    public Director getDirectorByName(String name){
        if(!directordbs.containsKey(name)) return null;
        return directordbs.get(name);
    }
    public List<String > getMoviesByDirectorName(String director){
        if(pairdbs.containsKey(director)){
            return pairdbs.get(director);
        }
        else{
            return null;
        }
    }

    public List<String > findAllMovies(){
        List<String > ans = new ArrayList<>();
        for(String name: moviedbs.keySet()){
            ans.add(name);
        }
        return ans;
    }

    public String deleteDirectorByName(String directorName){
        List<String> movies = pairdbs.get(directorName);
        for(int i=0; i<movies.size(); i++){
            if(moviedbs.containsKey(movies.get(i))){
                moviedbs.remove(movies.get(i));
            }
        }
        pairdbs.remove(directorName);
        if(directordbs.containsKey(directorName)){
            directordbs.remove(directorName);
        }
        return "Directors and movies are removed sucessfully";
    }
    public String deleteAllDirectors() {
        for (String dir : pairdbs.keySet()) {
            List<String> lis = pairdbs.get(dir);
            for (String name : lis) {
                if (moviedbs.containsKey(name)) {
                    moviedbs.remove(name);
                }
            }
            directordbs.remove(dir);
        }
        for (String d : directordbs.keySet()) {
            directordbs.remove(d);
        }

        return "All directors and all of their movies removed successfully";
    }
}
