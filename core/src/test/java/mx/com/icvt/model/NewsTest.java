package mx.com.icvt.model;

import org.junit.Ignore;
import org.junit.Test;

import java.text.ParseException;

import static junit.framework.Assert.assertNotNull;

public class NewsTest {
    @Test(expected = ParseException.class)
    public void testInstantationWithWrongDate() throws ParseException {
        new News("", "", "", "", "");
    }

    @Test
    public void testCorrectInstantation() throws ParseException {
        News news = new News("", "", "Wed, 26 Mar 2014 17:34:34 GMT", "", "");
        assertNotNull(news);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void testWithNulls() throws ParseException {
        new News(null, null, null, null, null);
    }
}
