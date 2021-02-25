import java.util.ArrayList;
public class RegiUser extends User {
    String id;
    String pasword;
    ArrayList<Movie> moviesWatched = new ArrayList<>();
    ArrayList<Movie> moviesLiked = new ArrayList<>();
    String paymentInfo;
    String savedAddress;
}
