package academy.everyonecodes.mongorockscissorspaper.domain;

public class GameResult {

    private String id;
    private String result;

    public GameResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
