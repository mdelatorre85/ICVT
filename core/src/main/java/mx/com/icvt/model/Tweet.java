package mx.com.icvt.model;

import twitter4j.GeoLocation;
import twitter4j.Status;
import twitter4j.User;

import java.util.Date;

/**
 * Created by miguelangeldelatorre on 01/04/14.
 */
public class Tweet {

    private Long id;
    private String text;
    private Date pubDate;
    private String url;
    private Double latitude;
    private Double longitude;
    private Integer retweetCount;
    private Integer favoriteCount;

    private Long userID;
    private String userScreenName;
    private String userName;
    private String userProfileUrl;


    @SuppressWarnings("unused")
    private Tweet(){}
    public Tweet(Status status) {
        id = status.getId();
        text = status.getText();
        pubDate = status.getCreatedAt();
        GeoLocation geo = status.getGeoLocation();
        if (geo != null){
            latitude = geo.getLatitude();
            longitude = geo.getLongitude();
        }
        favoriteCount = status.getFavoriteCount();
        retweetCount = status.getRetweetCount();

        User user = status.getUser();
        if (user!= null){
            userID = user.getId();
            userName = user.getName();
            userScreenName =user.getScreenName();
            userProfileUrl = user.getProfileImageURL();

            StringBuilder sb = new StringBuilder("https://twitter.com/");
            sb.append(userScreenName);
            sb.append("/status/");
            sb.append(id);
            url = sb.toString();
        }



    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Integer getRetweetCount() {
        return retweetCount;
    }

    public Integer getFavoriteCount() {
        return favoriteCount;
    }

    public Long getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserProfileUrl() {
        return userProfileUrl;
    }

    public String getUserScreenName() {
        return userScreenName;
    }

    public String getUrl() {
        return url;
    }
}
