package academy.everyonecodes.threepwoodcinema;

public class Template {

    private String name;
    private String keyword;
    private String message;

    public Template(String name, String keyword, String message) {
        this.name = name;
        this.keyword = keyword;
        this.message = message;
    }

    Template() {
    }

    public String getName() {
        return name;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getMessage() {
        return message;
    }

    void setName(String name) {
        this.name = name;
    }

    void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    void setMessage(String message) {
        this.message = message;
    }
}
