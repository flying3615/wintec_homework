package iphomework;

import java.util.Date;

/**
 * Created by liuyufei on 9/7/16.
 */
public class Data {

    private Date dateTime;
    private String latitude;
    private String longitude;


    public Data(Date dateTime, String latitude, String longitude) {
        this.dateTime = dateTime;
        this.latitude = latitude;
        this.longitude = longitude;
    }


    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}
