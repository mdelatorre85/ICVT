package mx.com.icvt.extraction.impl.patents;

import mx.com.icvt.extraction.ExtractorConfiguration;
import mx.com.icvt.extraction.DataExtractor;
import mx.com.icvt.extraction.ResultData;

/**
 * User: Cesar
 * Date: 09/03/14
 * Time: 10:13
 */
public class PatentsExtractor implements DataExtractor {

    @Override
    public ResultData extract(ExtractorConfiguration extractorConfiguration) {
        PatentsResultData resultData = new PatentsResultData();
//        resultData.setResult("Result data");
        return resultData;
    }
}
