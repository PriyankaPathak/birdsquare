package birdsquare.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

    @Id
    public String id;

    public int points = 0;

    private String username;

    public User() {
    }

    public User(String uid) {
        this.id = uid;
    }

    public User(String uid, String username) {
        this.username = username;
        this.id = uid;
    }

    public void incrementPointsByOne() {
        points = points + 1;
    }

    public int getPoints() {
        return points;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
