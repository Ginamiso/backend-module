package academy.everyonecodes.basket.domain;

import java.util.Objects;

public class Summary {

    private String userEmail;
    private String itemName;
    private double itemPrice;
    private double deliveryCost;
    private double totalPrice;

    Summary() {
    }

    public Summary(String userEmail, String itemName, double itemPrice, double deliveryCost, double totalPrice) {
        this.userEmail = userEmail;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.deliveryCost = deliveryCost;
        this.totalPrice = totalPrice;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public double getDeliveryCost() {
        return deliveryCost;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    void setItemName(String itemName) {
        this.itemName = itemName;
    }

    void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    void setDeliveryCost(double deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Summary summary = (Summary) o;
        return Double.compare(summary.itemPrice, itemPrice) == 0 &&
                Double.compare(summary.deliveryCost, deliveryCost) == 0 &&
                Double.compare(summary.totalPrice, totalPrice) == 0 &&
                Objects.equals(userEmail, summary.userEmail) &&
                Objects.equals(itemName, summary.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userEmail, itemName, itemPrice, deliveryCost, totalPrice);
    }
}
