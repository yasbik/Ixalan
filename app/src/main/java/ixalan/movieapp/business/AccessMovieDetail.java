package ixalan.movieapp.business;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;

import ixalan.movieapp.objects.Movie;

public class AccessMovieDetail
{
    private Movie movie;

    public AccessMovieDetail(Movie movie)
    {
        this.movie = movie;
    }

    public String getFullDetails()
    {
        String toReturn = "";
        if (movie != null) {
            toReturn += movie.getSynopsis();
            toReturn += "\n\n";
            toReturn += ("Rating: " + movie.getRating() + "/10\n\n");

            String str = movie.getCastCrew();
            int index = str.indexOf("Cast: ");

            if (index != -1) {
                toReturn += str.substring(0, index);
                toReturn += "\n";
                toReturn += str.substring(index);
            }
        }
        return toReturn;
    }

    public Intent watchYoutubeVideo()
    {
        Intent toReturn = null;
        if (movie != null)
        {
            String url = "http://www.youtube.com/watch?v="+movie.getTrailerUrl();
            try {
                Intent i = new Intent("android.intent.action.MAIN");
                i.setComponent(ComponentName.unflattenFromString("com.android.chrome/com.android.chrome.Main"));
                i.addCategory("android.intent.category.LAUNCHER");
                i.setData(Uri.parse(url));
                toReturn = i;
            }
            catch(ActivityNotFoundException e) {
                // Chrome is not installed
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                toReturn = i;
            }
        }
        return toReturn;
    }
}
