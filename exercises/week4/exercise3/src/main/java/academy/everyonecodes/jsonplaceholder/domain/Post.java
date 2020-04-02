package academy.everyonecodes.jsonplaceholder.domain;

import java.util.Objects;

public class Post {

    private String title;
    private String content;
    private int user;
    private int identifier;

    public Post() {
    }

    public Post(String title, String content, int user, int identifier) {
        this.title = title;
        this.content = content;
        this.user = user;
        this.identifier = identifier;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getUser() {
        return user;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return user == post.user &&
                identifier == post.identifier &&
                Objects.equals(title, post.title) &&
                Objects.equals(content, post.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, content, user, identifier);
    }
}
