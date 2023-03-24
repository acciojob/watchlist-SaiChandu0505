package com.driver;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public class MovieService {

MovieRepository movieRepository = new MovieRepository();

    public String addMovie(@RequestBody Movie movie){

        String ans = movieRepository.addMovie(movie);

        return ans;
    }
    public String addDirector(@RequestBody Director director){

        String ans = movieRepository.addDirector(director);

        return ans;
    }
    public String addMoviedirectorPair(@RequestParam("movieName") String movieName, @RequestParam("directorName") String directorName){

        String ans = movieRepository.addMovieDirectorPair(movieName, directorName);

        return ans;
    }
    public String getMovieByName(@PathVariable("name") String name){

        String ans = String.valueOf(movieRepository.getMovieByName(name));

        return ans;
    }

    public String getDirectorByName(@RequestParam("directorName")String director){

        String ans = movieRepository.getDirectorByName(director).toString();
        return ans;
    }


    public List<String> getMoviesByDirectorName(@RequestParam("directorName")String directorName){

        List<String> DirectorMovieList = movieRepository.getMoviesByDirectorName(directorName);
        return DirectorMovieList;
    }

    public List<String> findAllMovies(){

        List<String> movieList = movieRepository.findAllMovies();
        return movieList;
    }

    public String deleteDirectorByName(@RequestParam("directorName")String directorName){
        String ans = movieRepository.deleteDirectorByName(directorName);
        return ans;
    }

    public String deleteAllDirectors(){
        String ans = movieRepository.deleteAllDirectors();
        return ans;
    }
}
