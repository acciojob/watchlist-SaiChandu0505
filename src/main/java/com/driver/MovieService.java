package com.driver;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public class MovieService {

MovieRepository movieRepository = new MovieRepository();

    public String addMovie(Movie movie){
        return movieRepository.addMovie(movie);
    }
    public String addDirector(Director director){
        return movieRepository.addDirector(director);
    }
    public String addMovieDirectorPair(String movieName, String directorName){
        return movieRepository.addMovieDirectorPair(movieName, directorName);
    }
    public Movie getMovieByName(String name){
        return movieRepository.getMovieByName(name);
    }
    public Director getDirectorByName(String name){
        return movieRepository.getDirectorByName(name);
    }
    public List<String> getMoviesByDirectorName(String director){
        return movieRepository.getMoviesByDirectorName(director);
    }

    public List<String> findAllMovies(){
        return movieRepository.findAllMovies();
    }
    public String deleteDirectorByName(String directorName){
        return movieRepository.deleteDirectorByName(directorName);
    }
    public String deleteAllDirectors(){
        return movieRepository.deleteAllDirectors();
    }

}
