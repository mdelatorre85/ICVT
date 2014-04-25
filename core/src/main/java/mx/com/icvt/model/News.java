package mx.com.icvt.model;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


/**
 * @author miguelangeldelatorre
 */
public class News implements Serializable, Comparable<News> {


    private Long id;
    private String title = "";
    private String url = "";
    private String pubDateString;
    private Date pubDate;
    private String description = "";
    private String image = "";
    private String source = "";

    @SuppressWarnings("unused")
    private News() {
    }

    public News(String title, String url, String pubDateString, String description, String image) throws ParseException {
        if (url == null || url.length() == 0) {
            throw new IllegalArgumentException("Argument url cannot be null or empty.");
        }
        this.url = url;
        setSourceFromUrl();

        if (pubDateString == null || pubDateString.length() == 0) {
            throw new IllegalArgumentException("Argument pubDateString cannot be null or empty.");
        }
        this.pubDateString = pubDateString;

        if (title != null)
            this.title = title;

        if (description != null)
            this.description = description;

        if (image != null)
            this.image = image;

        try {
            SimpleDateFormat df = new SimpleDateFormat("EEE, dd MMM yyyy kk:mm:ss z",
                    Locale.ENGLISH);
            //Wed, 26 Mar 2014 17:34:34 GMT
            pubDate = df.parse(pubDateString);
        } catch (ParseException e) {
            e.printStackTrace();
            throw e;
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

    public void setUrl(String string) {
        this.url = string;
        setSourceFromUrl();
    }

    @Override
    public String toString() {
        return title + ", " + url;
    }

    public Long getID() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @param o
     * @return 0 en caso de que ambos objetos tengan el mismo contenido. -1 en caso de que este objeto tenga menos
     * contenido y 1 de lo contrario. La jerarquía de contenidos es imagen, descripción y título en orden decreciente.
     */
    @Override
    public int compareTo(News o) {
        if (id != null && o.id != null) {
            if (id.longValue() == o.id.longValue() && url.equals(o.url)) {
                if (image.equals(o.image) && description.equals(o.description) && title.equals(o.title)) {
                    return 0;
                } else if (image.length() == 0 && o.image.length() > 0) {
                    return -1;
                } else if (o.image.length() == 0 && image.length() > 0) {
                    return 1;
                } else if (description.length() == 0 && o.description.length() > 0) {
                    return -1;
                } else if (description.length() > 0 && o.description.length() == 0) {
                    return 1;
                } else if (description.length() != o.description.length()) {
                    return description.length() - o.description.length();
                } else if (title.length() == 0 && o.title.length() > 0) {
                    return -1;
                } else if (title.length() > 0 && o.title.length() == 0) {
                    return 1;
                } else if (title.length() != o.title.length()) {
                    return title.length() - o.title.length();
                }
            }
        }

        return url.compareTo(o.url);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof News) {
            News news = ((News) obj);
            if (id != null) {
                if (id.longValue() == news.id.longValue() && image.equals(news.image) && description.equals(news.description) && title.equals(news.title)) {
                    return true;
                } else if (image.equals(news.image) && description.equals(news.description) && title.equals(news.title)) {
                    return true;
                }
            }

        }
        return false;
    }

    public String getImage() {
        return image;
    }

    public String getSource() {
        return source;
    }

    private void setSourceFromUrl() {
        try {
            source = new URL(url).getHost();
            if (source.startsWith("www.")) {
                source = source.substring(4);
            }
        } catch (MalformedURLException ez) {
            ez.printStackTrace();
        }

    }
}
