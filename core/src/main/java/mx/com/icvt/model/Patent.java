package mx.com.icvt.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @author miguelangeldelatorre
 */
public class Patent implements Serializable {

    private Long id;
    private String tittle;
    private String descriptionText;
    private String url;
    private Date publicationDate;
    private String publicationStringDate;
    private String patentString;
    private List<String> authors;

    @SuppressWarnings("unused")
    private Patent() {
    }

    public  Patent(String tittle, String url) {
        this.tittle = tittle;
        this.url =url;
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

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setPublicationStringDate(String publicationStringDate) {
        this.publicationStringDate = publicationStringDate;

        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy",
                    Locale.ENGLISH);
            //Wed, 26 Mar 2014 17:34:34 GMT
            publicationDate =  df.parse(publicationStringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getPublicationStringDate() {
        return publicationStringDate;
    }

    public List<String> getAuthors() {
        if (authors == null)
            authors = new ArrayList<String>();
        return authors;
    }

    public String getPatentString() {
        return patentString;
    }

    public void setPatentString(String patentString) {
        this.patentString = patentString;
    }
}
