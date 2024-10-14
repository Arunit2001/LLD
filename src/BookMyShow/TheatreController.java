package BookMyShow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {
    Map<City, List<Theatre>> cityTheatreMapping = new HashMap<>();
    List<Theatre> theatreList = new ArrayList<>();

    // What is the difference between initializing the theatreList and cityTheatreMapping inside the constructor and outside the constructor.
    public TheatreController() {
        cityTheatreMapping = new HashMap<>();
        theatreList = new ArrayList<>();
    }

    void addTheatre(Theatre theatre, City city) {

        theatreList.add(theatre);

        List<Theatre> theatres = cityTheatreMapping.getOrDefault(city, new ArrayList<>());
        theatres.add(theatre);
        cityTheatreMapping.put(city, theatres);
    }


    Map<Theatre, List<Show>> getAllShow(Movie movie, City city) {

        //get all the theater of this city

        Map<Theatre, List<Show>> theatreVsShows = new HashMap<>();

        List<Theatre> theatres = cityTheatreMapping.get(city);

        //filter the theatres which run this movie

        for(Theatre theatre : theatres) {

            List<Show> givenMovieShows = new ArrayList<>();
            List<Show> shows = theatre.getShowList();

            for(Show show : shows) {
                if(show.movie.getId() == movie.getId()) {
                    givenMovieShows.add(show);
                }
            }
            if(!givenMovieShows.isEmpty()) {
                theatreVsShows.put(theatre, givenMovieShows);
            }
        }

        return theatreVsShows;
    }

}
