package academy.everyonecodes.validation;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

public class Artwork {

    @NotEmpty
    private String name;
    @Valid
    private Rating rating;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}
