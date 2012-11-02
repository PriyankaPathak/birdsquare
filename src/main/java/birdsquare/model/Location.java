package birdsquare.model;

public class Location {
    Double latitude ;
    Double longitude ;
    String locationname;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getLocationname() {
        return locationname;
    }

    public void setLocationname(String locationname) {
        this.locationname = locationname;
    }

    public Location(Double latitude, Double longitude, String locationname) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.locationname = locationname;
    }

    public Location(){};

}
