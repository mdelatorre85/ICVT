package mx.com.icvt.model;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @author miguelangeldelatorre
 */
public class Patent implements Comparable<Patent> {

    private Long id;
    private String tittle;
    private String descriptionText;
    private String url;
    private Date publicationDate;
    private String publicationStringDate;
    private String patentString;
    private List<String> authors;

    public Patent() {
    }

    public Patent(String tittle, String url) throws MalformedURLException {
        if (tittle == null || tittle.length() == 0) {
            throw new IllegalArgumentException("Argument tittle cannot be null or empty.");
        }
        if (url == null || url.length() == 0) {
            throw new IllegalArgumentException("Argument tittle cannot be null or empty.");
        }

        this.tittle = tittle;
        this.url = url;

        new URL(url);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescriptionText() {
        return descriptionText;
    }

    public void setDescriptionText(String descriptionText) {
        this.descriptionText = descriptionText;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public String getPublicationStringDate() {
        return publicationStringDate;
    }

    public void setPublicationStringDate(String publicationStringDate) throws ParseException {
        if (publicationStringDate == null || publicationStringDate.length() > 4 || publicationStringDate.length() <= 0) {
            throw new IllegalArgumentException("Argument publicationStringDate cannot be null or empty.");
        }
        this.publicationStringDate = publicationStringDate;

        SimpleDateFormat df = new SimpleDateFormat("yyyy",
                Locale.ENGLISH);
        //Wed, 26 Mar 2014 17:34:34 GMT
        publicationDate = df.parse(publicationStringDate);

    }

    public List<String> getAuthors() {
        if (authors == null)
            authors = new ArrayList<String>();
        return authors;
    }

    public void setAuthors(List<String> authors){
        this.authors = authors;
    }

    public String getPatentString() {
        return patentString;
    }

    public void setPatentString(String patentString) {
        this.patentString = patentString;
    }

    /**
     * @param o
     * @return En caso de ambos tengan un id definido regresa uno si este objeto tiene título
     * y descripción mas largos. Si el id no se encuentra definido regresa uno si estr objeto tiene
     * una fecha de publicación mas reciente, cero si es igual o menos uno si es anterior al
     * objeto que se esta comparando. por último si no se tiene fecha de publicación se comapran
     * simplemente por el url el cual no es nulo y tiene longitud mayor a cero.
     */
    @Override
    public int compareTo(Patent o) {
        if (id != null && o.id != null && id.longValue() == o.id.longValue()) {
            if (!tittle.equals(o.tittle)) {
                if (tittle.length() < o.tittle.length()) {
                    return -1;
                } else {
                    return 1;
                }
            } else if (descriptionText != null && o.descriptionText != null && !descriptionText.equals(o.descriptionText)) {
                if (descriptionText.length() < o.descriptionText.length()) {
                    return -1;
                } else {
                    return 1;
                }
            } else if (!url.equals(o.url)) {
                return url.compareTo(o.url);
            } else {
                return 0;
            }
        } else if (publicationDate != null && o.publicationDate != null) {
            return publicationDate.compareTo(o.publicationDate);
        } else {
            return url.compareTo(o.url);
        }
    }

    /**
     * equals consistente con comparador.
     *
     * @param obj
     * @return regresa true en caso de que ambos ids sean iguales o ambos nulos y URL y titulo sean iguales y
     * descripción sea igual o nulos en ambos objetos. false de lo contrario.
     */
    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Patent) {
            Patent patent = (Patent) obj;
            if ((id != null && patent.id != null && id.longValue() == patent.id.longValue()) || (id == null && patent.id == null))
                if (url.equals(patent.url) && tittle.equals(patent.tittle)) {
                    if (descriptionText != null && patent.descriptionText != null && descriptionText.equals(patent.descriptionText)) {
                        return true;
                    } else if (descriptionText == null && patent.descriptionText == null) {
                        return true;
                    }
                }
        }
        return false;
    }
}
