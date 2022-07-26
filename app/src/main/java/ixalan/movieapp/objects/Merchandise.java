package ixalan.movieapp.objects;

public class Merchandise extends CartItem
{
    private int merchID;
    private String description;
    private int movieTag; //movie to which this merchandise item is associated
    private int stock;
    private String imageUrl;

    public Merchandise(String name, float price)
    {
        super(name, price, 1);
    }

    public Merchandise(int merchID, String name, float price)
    {
        super(name, price, 1);
        this.merchID = merchID;
    }

    public Merchandise(float price, int quantity, String name, int merchID, String description, int movieTag, int stock, String imageUrl)
    {
        super(name, price, quantity);
        this.merchID = merchID;
        this.description = description;
        this.movieTag = movieTag;
        this.stock = stock;
        this.imageUrl = imageUrl;
    }

    public void setName(String name) {
        super.setName(name);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMovieTag(int movieTag) {
        this.movieTag = movieTag;
    }

    public void setPrice(float price) {
        super.setPrice(price);
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getName()
    {
        return super.getName();
    }

    public String getDescription()
    {
        return this.description;
    }

    public int getMovieTag()
    {
        return this.movieTag;
    }

    public float getPrice()
    {
        return super.getPrice();
    }

    public int getStock()
    {
        return this.stock;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl)
    {
        this.imageUrl = imageUrl;
    }

    public void setMerchId(int merchID)
    {
        this.merchID = merchID;
    }
    public int getMerchID()
    {
        return this.merchID;
    }

    public boolean equals(Merchandise merchandise)
    {
        return merchandise != null && this.getMerchID() == merchandise.getMerchID();
    }
}
