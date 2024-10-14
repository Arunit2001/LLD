package BookMyShow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookShow {
    MovieController movieController;
    TheatreController theatreController;

    public BookShow() {
        movieController = new MovieController();
        theatreController = new TheatreController();
    }


    public static void main(String args[]) {

        BookShow bookMyShow = new BookShow();

        bookMyShow.initialize();

        //user1
        bookMyShow.createBooking(City.Bangalore, "END GAME");
        //user2
        bookMyShow.createBooking(City.Bangalore, "END GAME");

    }

    private void createBooking(City userCity, String movieName) {


        //1. search movie by my location
        List<Movie> movies = movieController.getMoviesByCity(userCity);

        //2. select the movie which you want to see. i want to see endgame
        Movie interestedMovie = null;
        for (Movie movie : movies) {

            if ((movie.getName()).equals(movieName)) {
                interestedMovie = movie;
            }
        }

        //3. get all show of this movie in Bangalore location
        Map<Theatre, List<Show>> showsTheatreWise = theatreController.getAllShow(interestedMovie, userCity);

        //4. select the particular show user is interested in
        Map.Entry<Theatre,List<Show>> entry = showsTheatreWise.entrySet().iterator().next();
        List<Show> runningShows = entry.getValue();
        Show interestedShow = runningShows.get(0);

        //5. select the seat
        int seatNumber = 30;
        List<Integer> bookedSeats = interestedShow.getBookedSeatIds();
        if(!bookedSeats.contains(seatNumber)){
            bookedSeats.add(seatNumber);
            //startPayment
            Booking booking = new Booking();
            List<Seat> myBookedSeats = new ArrayList<>();
            for(Seat screenSeat : interestedShow.getScreen().getSeatList()) {
                if(screenSeat.getId() == seatNumber) {
                    myBookedSeats.add(screenSeat);
                }
            }
            booking.setBookedSeats(myBookedSeats);
            booking.setShow(interestedShow);
        } else {
            //throw exception
            System.out.println("seat already booked, try again");
            return;
        }

        System.out.println("BOOKING SUCCESSFUL");
    }

    private void initialize() {

        //create movies
        createMovies();

        //create theater with screens, seats and shows
        createTheatre();
    }

    //creating 2 theatre
    private void createTheatre() {

        Movie avengerMovie = movieController.getMovieByName("AVENGERS");
        Movie endgame = movieController.getMovieByName("END GAME");

        Theatre inoxTheatre = new Theatre("Theatre1", City.Bangalore);
        inoxTheatre.setScreenList(createScreen());
        List<Show> inoxShows = new ArrayList<>();
        Show inoxMorningShow = createShows(inoxTheatre.getScreenList().get(0), avengerMovie, 8);
        Show inoxEveningShow = createShows(inoxTheatre.getScreenList().get(0), endgame, 16);
        inoxShows.add(inoxMorningShow);
        inoxShows.add(inoxEveningShow);
        inoxTheatre.setShowList(inoxShows);


        Theatre pvrTheatre = new Theatre("Theatre2", City.Delhi);
        pvrTheatre.setScreenList(createScreen());
        List<Show> pvrShows = new ArrayList<>();
        Show pvrMorningShow = createShows(pvrTheatre.getScreenList().get(0), avengerMovie, 13);
        Show pvrEveningShow = createShows(pvrTheatre.getScreenList().get(0), endgame, 20);
        pvrShows.add(pvrMorningShow);
        pvrShows.add(pvrEveningShow);
        pvrTheatre.setShowList(pvrShows);

        theatreController.addTheatre(inoxTheatre, City.Bangalore);
        theatreController.addTheatre(pvrTheatre, City.Delhi);

    }

    private List<Screen> createScreen() {

        List<Screen> screens = new ArrayList<>();
        Screen screen1 = new Screen();
        screen1.setSeatList(createSeats());
        screens.add(screen1);

        return screens;
    }

    private Show createShows(Screen screen, Movie movie, int showStartTime) {

        Show show = new Show(movie, screen);
        show.setStartTime(showStartTime); //24 hrs time ex: 14 means 2pm and 8 means 8AM
        return show;
    }

    //creating 100 seats
    private List<Seat> createSeats() {

        //creating 100 seats for testing purpose, this can be generalised
        List<Seat> seats = new ArrayList<>();

        //1 to 40 : SILVER
        for (int i = 0; i < 40; i++) {
            Seat seat = new SilverSeat();
            seat.setPrice(250);
            seats.add(seat);
        }

        //41 to 70 : SILVER
        for (int i = 40; i < 70; i++) {
            Seat seat = new GoldSeat();
            seat.setPrice(350);
            seats.add(seat);
        }

        //1 to 40 : SILVER
        for (int i = 70; i < 100; i++) {
            Seat seat = new PlatinumSeat();
            seat.setPrice(500);
            seats.add(seat);
        }

        return seats;
    }

    private void createMovies() {

        //create Movies1
        Movie avengers = new Movie("AVENGERS");

        //create Movies2
        Movie endgame = new Movie("END GAME");


        //add movies against the cities
        movieController.addMovie(avengers, City.Bangalore);
        movieController.addMovie(avengers, City.Delhi);
        movieController.addMovie(endgame, City.Bangalore);
        movieController.addMovie(endgame, City.Delhi);
    }

}
