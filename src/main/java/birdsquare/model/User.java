package birdsquare.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

    @Id
    public String id;

    public int points;

    public User(String id) {
        this.id = id;
    }

    public User() {
    }

    public void incrementPointsByOne() {
        points=points+1;
    }

    public int getPoints() {
        return points;
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
