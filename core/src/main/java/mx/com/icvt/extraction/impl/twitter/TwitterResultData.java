package mx.com.icvt.extraction.impl.twitter;

import mx.com.icvt.extraction.ResultData;
import mx.com.icvt.model.Tweet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by miguelangeldelatorre on 01/04/14.
 */
public class TwitterResultData implements ResultData<Tweet> {

    private ArrayList<Tweet> results;
    private TwitterExtractorConfiguration configuration;
    private Date startDate;
    private Date endDate;

    public TwitterExtractorConfiguration getConfiguration() {
        return configuration;
    }

    void setConfiguration(TwitterExtractorConfiguration configuration) {
        this.configuration = configuration;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public List<Tweet> getResults() {
        if (results == null ){
            results = new ArrayList<Tweet>();
        }
        return results;
    }

    @Override
    public String toString() {
        return getResults().toString();
    }
}
