package ixalan.movieapp.objects;

public class Merchandise
{
    private String name;
    private String description;
    private Movie movieTag; //movie to which this merchandise item is associated
    private float price;
    private int stock;

    public Merchandise(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMovieTag(Movie movieTag) {
        this.movieTag = movieTag;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getName()
    {
        return this.name;
    }

    public String getDescription()
    {
        return this.description;
    }

    public Movie getMovieTag()
    {
        return this.movieTag;
    }

    public float getPrice()
    {
        return this.price;
    }

    public int getStock()
    {
        return this.stock;
    }
}
