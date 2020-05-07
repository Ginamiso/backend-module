package academy.everyonecodessteampurchases.domain;

import java.util.Objects;

public class Purchase {

    private String username;
    private String gameName;
    private String uuid;
    private double price;

    public Purchase() {
    }

    public Purchase(String username, String gameName, String uuid, double price) {
        this.username = username;
        this.gameName = gameName;
        this.uuid = uuid;
        this.price = price;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return Double.compare(purchase.price, price) == 0 &&
                Objects.equals(username, purchase.username) &&
                Objects.equals(gameName, purchase.gameName) &&
                Objects.equals(uuid, purchase.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, gameName, uuid, price);
    }
}
