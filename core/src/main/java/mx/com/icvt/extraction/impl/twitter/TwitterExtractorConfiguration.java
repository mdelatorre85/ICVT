package mx.com.icvt.extraction.impl.twitter;

import mx.com.icvt.extraction.ExtractorConfiguration;
import twitter4j.Query;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by miguelangeldelatorre on 01/04/14.
 */
public class TwitterExtractorConfiguration implements ExtractorConfiguration {
    private Long id;

    private String query;
    private TwitterSearchKind twitterSearchKind;
    private Query.ResultType resultType = null;
    private int count = 100;

    private Date dateStart = null;
    private Date dateEnd = null;

    private String dateStartString = null;
    private String dateEndString = null;

    private SimpleDateFormat sdf = null;

    @SuppressWarnings("unused")
    private TwitterExtractorConfiguration() {
    }

    public TwitterExtractorConfiguration(String query, TwitterSearchKind twitterSearchKind) {
        if (query == null || query.length() == 0) {
            throw new IllegalArgumentException("Argument query cannot be null or empty");
        }
        if (twitterSearchKind == null) {
            throw new IllegalArgumentException("Argument twitterSearchKind cannot be null");
        }
        this.query = query;
        this.twitterSearchKind = twitterSearchKind;
    }

    public String getQuery() {
        return query;
    }

    public TwitterSearchKind getTwitterSearchKind() {
        return twitterSearchKind;
    }

    @Override
    public String getStringUrl() {
        return null;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        if (count <= 0 && count > 100) {
            throw new IllegalArgumentException("Argument count has to be lager than 0 and less or equal than 100");
        }
        this.count = count;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
        if (dateStart != null) {
            if (sdf == null)
                sdf = new SimpleDateFormat("yyyy-MM-dd");
            dateStartString = sdf.format(dateStart);
        }
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
        if (dateEnd != null) {
            if (sdf == null)
                sdf = new SimpleDateFormat("yyyy-MM-dd");
            dateEndString = sdf.format(dateEnd);
        }
    }

    public String getDateEndString() {
        return dateEndString;
    }

    public void setDateEndString(String dateEndString) throws ParseException {
        if (dateEndString == null) {
            dateEnd = null;
            this.dateEndString = null;
        } else {
            if (dateEndString.trim().length() != 10) {
                this.dateEndString = dateEndString;
                dateEnd = sdf.parse(dateEndString);
            }

        }

    }

    public String getDateStartString() {
        return dateStartString;
    }

    public void setDateStartString(String dateStartString) throws ParseException {
        if (dateStartString == null) {
            this.dateStartString = null;
            dateStart = null;
        } else {
            if (dateStartString.trim().length() != 10) {
                this.dateStartString = dateStartString;
                dateStart = sdf.parse(dateStartString);
            }
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public enum TwitterSearchKind {
        USERTIMELINE, SEARCHQUERY;
    }

    public Query.ResultType getResultType() {
        return resultType;
    }

    /**
     * Solo aplica para la búsqueda
     *
     * @param resultType
     */
    public void setResultType(Query.ResultType resultType) {
        this.resultType = resultType;
    }
}
