package mx.com.icvt.model;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


public class News implements Serializable, Comparable<News> {
    private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private static final long serialVersionUID = 5859859502959765439L;

    private Long id;
    private String title;
    private String url = "";
    private String pubDateString;
    private Date pubDate;
    private String description;
    private String image;
    private String source;
    private Map<Long, String> etiquetas;

    public News(Long id, String title, String url, Date pubDate, String description, String image, String source) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.pubDate = pubDate;
        this.description = description;
        this.image = image;
        this.source = source;
        this.etiquetas = new HashMap<Long, String>();
    }

    public News(String title, String url, String pubDateString, String description, String image) throws ParseException, MalformedURLException {
        if (url == null || url.length() == 0) {
            throw new IllegalArgumentException("Argument url cannot be null or empty.");
        }
        this.url = url;
        setSourceFromUrl();

        if (pubDateString == null || pubDateString.length() == 0) {
            throw new IllegalArgumentException("Argument pubDateString cannot be null or empty.");
        }
        this.pubDateString = pubDateString;
        this.title = title;
        this.description = description;

        if (image != null)
            this.image = image;

        SimpleDateFormat df = new SimpleDateFormat("EEE, dd MMM yyyy kk:mm:ss z",
                Locale.ENGLISH);
        //Wed, 26 Mar 2014 17:34:34 GMT


        pubDate = df.parse(pubDateString);
        this.etiquetas = new HashMap<Long, String>();
    }

    public String getPubDateString() {
        return DATE_FORMAT.format(pubDate);
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

    public void setUrl(String string) throws MalformedURLException {
        if (url == null || url.length() == 0) {
            throw new IllegalArgumentException("Argument url cannot be null or empty.");
        }
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
        if (url.equals(o.url)) {
            if (id != null && o.id != null) {
                if (id.longValue() < o.id.longValue()) {
                    return -1;
                } else if (id.longValue() > o.id.longValue()) {
                    return 1;
                }
            } else if (id != null && o.id == null) {
                return 1;
            } else if (id == null && o.id != null) {
                return -1;
            } else if (image != null && o.image == null) {
                return 1;
            } else if (image == null && o.image != null) {
                return -1;
            } else if (description != null && o.description == null) {
                return 1;
            } else if (description == null && o.description != null) {
                return -1;
            } else if (description != null && o.description != null) {
                if (description.length() > o.description.length()) {
                    return 1;
                } else if (description.length() < o.description.length()) {
                    return -1;
                }
            } else if (title != null && o.title == null) {
                return 1;
            } else if (title == null && o.title != null) {
                return -1;
            } else if (title != null && o.title != null) {
                if (title.length() > o.title.length()) {
                    return 1;
                } else if (title.length() < o.title.length()) {
                    return -1;
                }
            } else if (!pubDate.equals(o.pubDate)) {
                return pubDate.compareTo(o.pubDate);
            } else {
                return 0;
            }
        }
        return url.compareTo(o.url);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof News) {
            News news = ((News) obj);

            if (id != null && news.id != null) {
                if (id.longValue() != news.getID().longValue()) {
                    return false;
                }
            } else if ((id != null && news.id == null) || (id == null && news.id != null)) {
                return false;
            }

            if (url != null && news.getUrl() != null) {
                if (!url.equals(news.getUrl())) {
                    return false;
                }
            } else if ((url != null && news.getUrl() == null) || (url == null && news.getUrl() != null)) {
                return false;
            }

            if (title != null && news.getTitle() != null) {
                if (!title.equals(news.getTitle())) {
                    return false;
                }
            } else if ((title != null && news.getTitle() == null) || (title == null && news.getTitle() != null)) {
                return false;
            }

            if (image != null && news.getImage() != null) {
                if (!image.equals(news.getImage())) {
                    return false;
                }
            } else if ((image != null && news.getImage() == null) || (image == null && news.getImage() != null)) {
                return false;
            }

            if (description != null && news.getDescription() != null) {
                if (!description.equals(news.getDescription())) {
                    return false;
                }
            } else if ((description != null && news.getDescription() == null) || (description == null && news.getDescription() != null)) {
                return false;
            }

            if (pubDate != null && news.getPubDate() != null) {
                if (!pubDate.equals(news.getPubDate())) {
                    return false;
                }
            } else if ((pubDate != null && news.getPubDate() == null) || (pubDate == null && news.getPubDate() != null)) {
                return false;
            }

            return true;
        }
        return false;
    }

    public String getImage() {
        return image;
    }

    public String getSource() {
        return source;
    }

    private void setSourceFromUrl() throws MalformedURLException {
        source = new URL(url).getHost();
        if (source.startsWith("www.")) {
            source = source.substring(4);
        }
    }

    public void setEtiquetas(Map<Long, String> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public void addEtiqueta(Long id, String value) {
        this.etiquetas.put(id, value);
    }

    public Map<Long, String> getEtiquetas() {
        return this.etiquetas;
    }
}
