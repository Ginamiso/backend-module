package academy.everyonecodes.jsonplaceholder.domain;

import java.util.Objects;

public class PostDTO {

    private String title;
    private String body;
    private int userId;
    private int id;

    public PostDTO() {
    }

    public PostDTO(String title, String body, int userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostDTO postDTO = (PostDTO) o;
        return userId == postDTO.userId &&
                id == postDTO.id &&
                Objects.equals(title, postDTO.title) &&
                Objects.equals(body, postDTO.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, body, userId, id);
    }
}
