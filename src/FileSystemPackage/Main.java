package FileSystemPackage;

public class Main {
    public static void main(String[] args) {
        Directory movieDirectory = new Directory("Movies");
        Directory comedyMovie = new Directory("Comedy Movies");
        comedyMovie.addToDirectory(new File("Phir Hera Pheri"));
        comedyMovie.addToDirectory(new File("Hulchul"));
        movieDirectory.addToDirectory(comedyMovie);
        movieDirectory.addToDirectory(new File("Endgame"));
        movieDirectory.addToDirectory(new File("Batman"));
        movieDirectory.ls("");
    }
}
