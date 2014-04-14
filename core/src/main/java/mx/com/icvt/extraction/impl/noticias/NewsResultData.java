package mx.com.icvt.extraction.impl.noticias;

import mx.com.icvt.extraction.ResultData;
import mx.com.icvt.model.News;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by miguelangeldelatorre on 25/03/14.
 */
public class NewsResultData implements ResultData<News> {

    private ArrayList<News> results;
    private NewsExtractorConfiguration configuration;
    private Date startDate;
    private Date endDate;

    @Override
    public ArrayList<News> getResults() {
        if (results == null)
            results = new ArrayList<News>();

        return results;
    }

    public NewsExtractorConfiguration getConfiguration() {
        return configuration;
    }

    void setConfiguration(NewsExtractorConfiguration configuration) {
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
    public String toString() {
        return getResults().toString();
    }

}
