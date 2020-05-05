package academy.everyonecodes.smallbusiness.persistence.domain;

public class Product {

    private String id;
    private String name;
    private double price;
    private boolean isPremium;

    public Product() {
    }

    public Product(String name, double price, boolean isPremium) {
        this.name = name;
        this.price = price;
        this.isPremium = isPremium;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }
}
