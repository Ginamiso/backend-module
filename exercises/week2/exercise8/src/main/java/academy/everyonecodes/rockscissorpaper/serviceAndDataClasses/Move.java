package academy.everyonecodes.rockscissorpaper.serviceAndDataClasses;

public class Move {

    private String name;
    private String defeats;

    public Move(String name, String defeats) {
        this.name = name;
        this.defeats = defeats;
    }

    public Move() {
    }

    public String getName() {
        return name;
    }

    public String getDefeats() {
        return defeats;
    }

    void setName(String name) {
        this.name = name;
    }

    void setDefeats(String defeats) {
        this.defeats = defeats;
    }
}
