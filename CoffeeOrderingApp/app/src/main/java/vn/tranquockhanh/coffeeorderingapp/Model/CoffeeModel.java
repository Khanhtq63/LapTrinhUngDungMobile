package vn.tranquockhanh.coffeeorderingapp.Model;

import com.google.firebase.firestore.DocumentId;

public class CoffeeModel {

    @DocumentId
    private String coffeeId;
    private String imageURL, description, coffeename;
    private int price,quantity;

    public CoffeeModel() {
    }

    public CoffeeModel(String coffeeId, String imageURL, String description, String coffeename, int price, int quantity) {
        this.coffeeId = coffeeId;
        this.imageURL = imageURL;
        this.description = description;
        this.coffeename = coffeename;
        this.price = price;
        this.quantity = quantity;
    }

    public String getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeeId(String coffeeId) {
        this.coffeeId = coffeeId;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoffeename() {
        return coffeename;
    }

    public void setCoffeename(String coffeename) {
        this.coffeename = coffeename;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CoffeeModel{" +
                "coffeeId='" + coffeeId + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", description='" + description + '\'' +
                ", coffeename='" + coffeename + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
