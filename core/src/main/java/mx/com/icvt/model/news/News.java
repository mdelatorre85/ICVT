package mx.com.icvt.model.news;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


/**
 * @author miguelangeldelatorre
 */
public class News implements Serializable, Comparable<News> {


    private Long id;
    private String title;
    private String url;
    private String pubDateString;
    private Date pubDate;
    private String description;
    private String image;

    @SuppressWarnings("unused")
    private News() {
    }

    public News(String title, String url, String pubDateString, String description, String image) {
        this.title = title;
        this.url = url;
        this.pubDateString = pubDateString;
        this.description = description;
        this.image = image;

        try {
            SimpleDateFormat df = new SimpleDateFormat("EEE, dd MMM yyyy kk:mm:ss z",
                    Locale.ENGLISH);
            //Wed, 26 Mar 2014 17:34:34 GMT
            pubDate = df.parse(pubDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getPubDateString() {
        return pubDateString;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return title + "," + url;
    }

    public Long getID() {
        return id;
    }

    public void setUrl(String string) {
        this.url = string;
    }

    @Override
    public int compareTo(News o) {
        return pubDate.compareTo(o.pubDate);
    }

    public String getImage() {
        return image;
    }
}
