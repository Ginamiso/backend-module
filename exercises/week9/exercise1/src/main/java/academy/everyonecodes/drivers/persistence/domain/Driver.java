package academy.everyonecodes.drivers.persistence.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Driver {

    private String id;
    private String username;
    private String password;
    private Set<String> authorities = new HashSet<>();
    private String carType;
    private boolean isAvailable;

    public Driver() {
    }

    public Driver(String username, String password, String carType) {
        this.username = username;
        this.password = password;
        this.carType = carType;
    }

    public Driver(String username, String password, Set<String> authorities, String carType, boolean isAvailable) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.carType = carType;
        this.isAvailable = isAvailable;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return isAvailable == driver.isAvailable &&
                Objects.equals(id, driver.id) &&
                Objects.equals(username, driver.username) &&
                Objects.equals(password, driver.password) &&
                Objects.equals(authorities, driver.authorities) &&
                Objects.equals(carType, driver.carType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, authorities, carType, isAvailable);
    }
}
