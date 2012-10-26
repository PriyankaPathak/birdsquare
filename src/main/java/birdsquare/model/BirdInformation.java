package birdsquare.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BirdInformation {
    @Id
    private String birdName;
    private String weight;
    private String message;

    public BirdInformation() {
    }

    public BirdInformation(String birdName, String weight, String message) {
        this.birdName = birdName;
        this.weight = weight;
        this.message = message;
    }

    public String getBirdName() {
        return birdName;
    }

    public void setBirdName(String birdName) {
        this.birdName = birdName;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String toString() {
        return birdName + " " + weight + " " + message;
    }
}
