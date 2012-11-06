package birdsquare.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

    @GenericGenerator(name = "generator", strategy = "increment")
    @Id
    @GeneratedValue(generator = "generator")
    public long id;
    public String name;
    public int points;

    public User(long id, String name, int points) {
        this.id = id;
        this.name = name;
        this.points = points;
    }


    public long getId() {
        return id;
    }

    public String getname() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setname(String name) {
        this.name = name;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public User(){}
}
