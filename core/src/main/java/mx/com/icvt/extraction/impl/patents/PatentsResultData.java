package mx.com.icvt.extraction.impl.patents;

import mx.com.icvt.extraction.ResultData;
import mx.com.icvt.model.Patent;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Cesar
 * Date: 09/03/14
 * Time: 11:13
 */
public class PatentsResultData implements ResultData<Patent> {

    private List<Patent> results;
    private PatentsExtractorConfiguration configuration;
    private Date startDate;
    private Date endDate;


    @Override
    public List<Patent> getResults() {
        if (results ==  null){
            results = new ArrayList<Patent>();
        }
        return results;
    }

    public PatentsExtractorConfiguration getConfiguration() {
        return configuration;
    }

    void setConfiguration(PatentsExtractorConfiguration configuration) {
        this.configuration = configuration;
    }

    public Date getStartDate() {
        return startDate;
    }

    void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
