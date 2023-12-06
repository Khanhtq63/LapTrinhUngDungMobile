package vn.tranquockhanh.coffeeorderingapp.Model;

import com.google.firebase.firestore.DocumentId;

public class CoffeeModel {

    @DocumentId
    private String coffeeId;
    private String imageURL, description, coffeename;
    private int price;

    public CoffeeModel() {
    }

    public CoffeeModel(String description, String imageURL, String coffeename, String coffeeId, int price) {
        this.description = description;
        this.imageURL = imageURL;
        this.coffeename = coffeename;
        this.coffeeId = coffeeId;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getCoffeename() {
        return coffeename;
    }

    public void setCoffeename(String coffeename) {
        this.coffeename = coffeename;
    }

    public String getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeeId(String coffeeId) {
        this.coffeeId = coffeeId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CoffeeModel{" +
                "description='" + description + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", coffeename='" + coffeename + '\'' +
                ", coffeeId='" + coffeeId + '\'' +
                ", price=" + price +
                '}';
    }
}
