package birdsquare.model;

import birdsquare.helper.BirdSquareSession;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "checkin")
public class Checkin {

    @GenericGenerator(name = "generator", strategy = "increment")
    @Id
    @GeneratedValue(generator = "generator")
    private long id;

    private long birdID;

    private String locationName;

    private int number;
    private Date date = new Date();
    private double longitude;
    private double latitude;
    private String comments;
    //    @ManyToOne
//    @JoinColumn(name = "fbuid")
//
    public String fbuid;

    public String getFbuid() {
        return fbuid;
    }

    public void setFbuid(String fbuid) {
        this.fbuid = fbuid;
    }

    public long getId() {
        return id;
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

    public void setLocationName(String locationName) {
        this.locationName = locationName;
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

    public List<String> getBirdNameList(BirdSquareSession birdSquareSession) {
            List<String> birdNameList = new ArrayList();
            List allBirds = birdSquareSession.getAll(Bird.class);
            for (Object bird : allBirds) {
                String name = ((Bird)bird).getCommon_name()+" ("+((Bird)bird).getScientific_name()+")";

                birdNameList.add(name);
            }
            return birdNameList;
    }

    public void setBirdId(int birdID) {
        this.birdID=birdID;
    }

    public long getBirdID() {
        return birdID;
    }

    public void setBirdID(long birdID) {
        this.birdID = birdID;
    }


}
