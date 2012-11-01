package birdsquare.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "checkin")
public class Checkin {

    @GenericGenerator(name = "generator", strategy = "increment")
    @Id
    @GeneratedValue(generator = "generator")
    public long id;
    public String birdname;
    public String comments;
    public String locationName;
    public int number;
    public Date date;
    public double longitude;
    public double latitude;

    public Checkin() {
    }

    public Checkin(String birdname, int number, String locationName, String comments) {
        this.birdname = birdname;
        this.locationName = locationName;
        this.number = number;
        this.comments = comments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String location) {
        this.locationName = location;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBirdname() {
        return birdname;
    }

    public void setBirdname(String birdname) {
        this.birdname = birdname;
    }
}
