package BookMyShow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {
    Map<City, List<Movie>> cityMovieMapping = new HashMap<>();
    List<Movie> movieList = new ArrayList<>();

    //ADD movie to a particular city, make use of cityMovieMapping map
    void addMovie(Movie movie, City city) {

        movieList.add(movie);

        List<Movie> movies = cityMovieMapping.getOrDefault(city, new ArrayList<>());
        movies.add(movie);
        cityMovieMapping.put(city, movies);
    }


    Movie getMovieByName(String movieName) {

        for(Movie movie : movieList) {
            if((movie.getName()).equals(movieName)) {
                return movie;
            }
        }
        return null;
    }


    List<Movie> getMoviesByCity(City city) {
        return cityMovieMapping.get(city);
    }
    //REMOVE movie from a particular city, make use of cityMovieMapping map

    //UPDATE movie of a particular city, make use of cityMovieMapping map

    //CRUD operation based on Movie ID, make use of movieList list

}
