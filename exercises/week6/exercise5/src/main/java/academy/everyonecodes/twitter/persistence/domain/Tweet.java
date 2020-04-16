package academy.everyonecodes.twitter.persistence.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Tweet {

    private String id;
    private String user;
    private String text;
    private int likes;
    private List<String> comments;
    private LocalDateTime timestamp;

    Tweet() {
    }

    public Tweet(String user, String text, int likes, List<String> comments, LocalDateTime timestamp) {
        this.user = user;
        this.text = text;
        this.likes = likes;
        this.comments = comments;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getText() {
        return text;
    }

    public int getLikes() {
        return likes;
    }

    public List<String> getComments() {
        return comments;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    void setId(String id) {
        this.id = id;
    }

    void setUser(String user) {
        this.user = user;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tweet tweet = (Tweet) o;
        return likes == tweet.likes &&
                Objects.equals(id, tweet.id) &&
                Objects.equals(user, tweet.user) &&
                Objects.equals(text, tweet.text) &&
                Objects.equals(comments, tweet.comments) &&
                Objects.equals(timestamp, tweet.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, text, likes, comments, timestamp);
    }
}
