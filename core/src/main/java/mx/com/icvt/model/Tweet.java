package mx.com.icvt.model;

import twitter4j.GeoLocation;
import twitter4j.Status;
import twitter4j.User;

import java.util.Date;

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

    public Tweet() {
        this.id = 0l;
        this.text = "";
        this.pubDate = new Date();
        this.url = "";
        this.latitude = 0d;
        this.longitude = 0d;
        this.retweetCount = 0;
        this.favoriteCount = 0;
        this.userID = 0l;
    }

    public Tweet(Status status) {
        id = status.getId();
        text = status.getText();
        pubDate = status.getCreatedAt();
        GeoLocation geo = status.getGeoLocation();
        if (geo != null) {
            latitude = geo.getLatitude();
            longitude = geo.getLongitude();
        }
        favoriteCount = status.getFavoriteCount();
        retweetCount = status.getRetweetCount();

        User user = status.getUser();
        if (user != null) {
            userID = user.getId();
            userName = user.getName();
            userScreenName = user.getScreenName();
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setRetweetCount(Integer retweetCount) {
        this.retweetCount = retweetCount;
    }

    public void setFavoriteCount(Integer favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public void setUserScreenName(String userScreenName) {
        this.userScreenName = userScreenName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserProfileUrl(String userProfileUrl) {
        this.userProfileUrl = userProfileUrl;
    }
}
