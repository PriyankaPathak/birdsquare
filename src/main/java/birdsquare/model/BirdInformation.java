package birdsquare.model;

public class BirdInformation {
    private final String birdname;
    private final int number;
    private final String location;
    private final String comments;

    public int getNumber() {
        return number;
    }

    public String getLocation() {
        return location;
    }

    public String getComments() {
        return comments;
    }

    public BirdInformation(String birdname, int number, String location, String comments) {
        this.birdname = birdname;
        this.number = number;
        this.location = location;
        this.comments = comments;
    }

    public String getBirdname() {
        return birdname;
    }
}
