package mx.com.icvt.model;

import twitter4j.GeoLocation;
import twitter4j.Status;
import twitter4j.User;

import java.util.Date;

/**
 * Created by miguelangeldelatorre on 01/04/14.
 */
public class Tweet implements Comparable<Tweet> {

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
    private Tweet() {
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

    /**
     * @param o
     * @return 0 en caso de que los ids de ambos objetos, cuenta de RTs y Favs sean identicos.
     * 1 en caso de que sus ids sean iguales pero este objeto tenga mas RTs o Favs o que sus ids sean diferentes y
     * este objeto tenga una fecha de publicación mas reciente.
     * -1 en caso de que sus ids sean iguales pero este objeto tenga menos RTs o Favs o que sus ids sean diferentes y
     * este objeto tenga una fecha de publicación menos reciente.
     */
    @Override
    public int compareTo(Tweet o) {
        if (id == o.id) {
            if (retweetCount == o.retweetCount && favoriteCount == o.favoriteCount) {
                return 0;
            } else if (retweetCount < o.retweetCount || favoriteCount < o.favoriteCount) {
                return -1;
            } else if (favoriteCount > o.favoriteCount || retweetCount > o.retweetCount) {
                return 1;
            }
        } else {
            if (pubDate.getTime() < o.pubDate.getTime()) {
                return -1;
            } else {
                return 1;
            }
        }
        return 0;
    }

    /**
     *
     * @param obj
     * @return True en caso de que sean de la misma clase que sus ids, RTs y Favs sean identicos.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof  Tweet){
            Tweet other = ((Tweet)obj);
            if (id == other.id && retweetCount == other.retweetCount &&  favoriteCount== other.favoriteCount){
                return true;
            }
        }
        return false;
    }
}
