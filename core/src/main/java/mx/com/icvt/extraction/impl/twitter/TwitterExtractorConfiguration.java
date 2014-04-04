package mx.com.icvt.extraction.impl.twitter;

import mx.com.icvt.extraction.ExtractorConfiguration;

/**
 * Created by miguelangeldelatorre on 01/04/14.
 */
public class TwitterExtractorConfiguration implements ExtractorConfiguration {

    private String query;
    private TwitterSearchKind twitterSearchKind;

    @SuppressWarnings("unused")
    private TwitterExtractorConfiguration(){}

    public TwitterExtractorConfiguration(String query, TwitterSearchKind twitterSearchKind){
        if (query == null || query.length()==0){
            throw new IllegalArgumentException("Argument query cannot be null or empty");
        }
        if (twitterSearchKind == null){
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

    public enum TwitterSearchKind{
        USERTIMELINE, SEARCHQUERY;
    }


}
