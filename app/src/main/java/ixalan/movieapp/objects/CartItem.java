package ixalan.movieapp.objects;

public class CartItem
{
    private float price;
    private int quantity;
    private String name;

    public CartItem(String name, float price, int quantity)
    {
        this.price = price;
        this.name = name;
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
