package com.driver;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    MovieService movieService = new MovieService();
    @PostMapping("/add-movie")
    public String addMovie(@RequestBody Movie movie){

        String ans = movieService.addMovie(movie);

        return ans;
    }

    @PostMapping("/add-director")
    public String addDirector(@RequestBody Director director){

        String ans = movieService.addDirector(director);

        return ans;
    }
    @PutMapping("/add-movie-director-pair")
    public String addMoviedirectorPair(@RequestParam("movieName") String movieName, @RequestParam("directorName") String directorName){

        String ans = movieService.addMoviedirectorPair(movieName, directorName);

        return ans;
    }
    @GetMapping("/get-movie-by-name")
    public String getMovieByName(@PathVariable("name") String name){

        String ans = movieService.getMovieByName(name);

        return ans;
    }

    @GetMapping("/get-director-by-name")
    public String getDirectorByName(@RequestParam("directorName")String directorName){

        String ans = movieService.getDirectorByName(directorName);
        return ans;
    }

    @GetMapping("/get-movies-by-director-name")
    public List<String> getMoviesByDirectorName(@RequestParam("directorName")String directorName){

        List<String> DirectorMovieList = movieService.getMoviesByDirectorName(directorName);
        return DirectorMovieList;
    }
    @GetMapping("/find-all-movies")
    public List<String> findAllMovies(){

        List<String> movieList = movieService.findAllMovies();
        return movieList;
    }
    @DeleteMapping("/delete-director-by-name")
    public String deleteDirectorByName(@RequestParam("directorName")String directorName){
        String ans = movieService.deleteDirectorByName(directorName);
        return ans;
    }
    @DeleteMapping("/delete-all-directors")
    public String deleteAllDirectors(){
        String ans = movieService.deleteAllDirectors();
        return ans;
    }
}
