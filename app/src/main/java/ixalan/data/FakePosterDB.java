package ixalan.data;
import java.util.ArrayList;
import java.lang.Integer;

public class FakePosterDB implements IPosterDB{
    ArrayList<String> posters;
    ArrayList<Integer> movieIDs;

    public FakePosterDB(){
        posters = new ArrayList<String>();
        movieIDs = new ArrayList<Integer>();
    }

    // inserts a new poster into the posters database and return -1 if failed
    @Override
    public int insertPoster(String posterURL, int movieID){
        Integer id;
        int status = -1;

        if( movieID >= 0) {
            id = new Integer(movieID);
            posters.add(posterURL);
            movieIDs.add(id);
            status = 1;
        }

        return status;
    }

    //gets the poster URL as a string returns an empty string if not found
    @Override
    public String getPoster(int movieID){
        int index=0;
        String posterURL= " ";
        int tempID;
        boolean found = false;


        while(index < posters.size() && !found){
            tempID = movieIDs.get(index).intValue();

            if(tempID == movieID){
                found = true;
                posterURL = posters.get(index);
            }
            if(!found){
                index++;
            }
        }
        return  posterURL;
    }
}

