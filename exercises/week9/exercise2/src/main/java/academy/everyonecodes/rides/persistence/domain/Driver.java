package academy.everyonecodes.rides.persistence.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Driver {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String username;

    private String carType;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Ride> rides = new ArrayList<>();

    public Driver() {
    }

    public Driver(String username, String carType) {
        this.username = username;
        this.carType = carType;
    }

    public Driver(Long id, String username, String carType, List<Ride> rides) {
        this.id = id;
        this.username = username;
        this.carType = carType;
        this.rides = rides;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public List<Ride> getRides() {
        return rides;
    }

    public void setRides(List<Ride> rides) {
        this.rides = rides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return Objects.equals(id, driver.id) &&
                Objects.equals(username, driver.username) &&
                Objects.equals(carType, driver.carType) &&
                Objects.equals(rides, driver.rides);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, carType, rides);
    }
}
