package mx.com.icvt.extraction.impl.patents;

import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: Cesar
 * Date: 09/03/14
 * Time: 14:16
 */
public class PatentsExtractorTest extends TestCase {
    public void testExtract() throws Exception {
        PatentsExtractor extractor = new PatentsExtractor();
        assertEquals(((PatentsResultData)extractor.extract(null)).getResult(), "Result data");
    }
}
