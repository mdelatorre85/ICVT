package mx.com.icvt.extraction;

/**
 * User: Cesar
 * Date: 09/03/14
 * Time: 09:47
 */
public interface DataExtractor <T1 extends ExtractorConfiguration,T2 extends ResultData>{

    public T2 extract(T1 extractorConfiguration);


}
