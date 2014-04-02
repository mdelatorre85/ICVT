package mx.com.icvt.extraction.impl.patents;

import mx.com.icvt.extraction.ExtractorConfiguration;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Cesar
 *
 * @author miguelangeldelatorre
 *         Date: 09/03/14
 *         Time: 11:15
 */
public class PatentsExtractorConfiguration implements Serializable, ExtractorConfiguration {

    private String query;
    private Boolean allintitle = Boolean.FALSE; //as_occt=title
    private String author = null; //&as_sauthors=Miguel
    private String publishedIn = null; //as_publication
    private Boolean patents = Boolean.FALSE;//as_publication=Google+Patents

    private Integer publicationDateStart; //as_ylo=1995
    private Integer publicationDateEnd; //as_yhi=2005

    private int page = 1; // start


    public PatentsExtractorConfiguration(String query) {
        if (query == null || query.length() == 0) {
            throw new IllegalArgumentException("Argument query cannot be null or empty");
        }
        this.query = query;
    }


    @Override
    public String getStringUrl() {
        StringBuilder sb = new StringBuilder("http://scholar.google.com.mx/scholar?q=");
        sb.append(query.replace(' ', '+'));

        if (allintitle) {
            sb.append("&as_occt=title");
        }

        if (author != null && author.length() > 0) {
            sb.append("&as_sauthors=");
            sb.append(author.replace(' ', '+'));
        }

        if (patents) {
            sb.append("&as_publication=");
        } else if (publishedIn != null && publishedIn.length() > 0) {
            sb.append("&as_publication=");
            sb.append(publishedIn.replace(' ', '+'));
        }

        if (publicationDateStart != null) {
            sb.append("&as_ylo=");
            sb.append(publicationDateStart.intValue());
        }

        if (publicationDateEnd != null) {
            sb.append("&as_yhi=");
            sb.append(publicationDateEnd.intValue());
        }

        if (page > 1) {
            sb.append("&start=");
            sb.append((page - 1) * 10);
        }

        return sb.toString();
    }

    public String getQuery() {
        return query;
    }

    void setQuery(String query) {
        this.query = query;
    }

    public Boolean isAllintitle() {
        return allintitle;
    }

    void setAllintitle(Boolean allintitle) {
        this.allintitle = allintitle;
    }

    public String getAuthor() {
        return author;
    }

    void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishedIn() {
        return publishedIn;
    }

    void setPublishedIn(String publishedIn) {
        this.publishedIn = publishedIn;
    }

    public Boolean isPatents() {
        return patents;
    }

    void setPatents(Boolean patents) {
        this.patents = patents;
    }

    public Integer getPublicationDateStart() {
        return publicationDateStart;
    }

    void setPublicationDateStart(Integer publicationDateStart) {
        this.publicationDateStart = publicationDateStart;
    }

    public Integer getPublicationDateEnd() {
        return publicationDateEnd;
    }

    void setPublicationDateEnd(Integer publicationDateEnd) {
        this.publicationDateEnd = publicationDateEnd;
    }

    public int getPage() {
        return page;
    }

    void setPage(int page) {
        this.page = page;
    }
}
