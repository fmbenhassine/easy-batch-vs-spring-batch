package common;

/**
 * Java bean representing a tweet.
 */
public class Tweet {

    private int id;

    private String user;

    private String message;

    public Tweet() {
    }

    public Tweet(int id, String user, String message) {
        this.id = id;
        this.user = user;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}