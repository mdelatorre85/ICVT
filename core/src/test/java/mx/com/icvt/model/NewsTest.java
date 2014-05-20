package mx.com.icvt.model;

import org.junit.Ignore;
import org.junit.Test;

import java.net.MalformedURLException;
import java.text.ParseException;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

public class NewsTest {
    @Test(expected = ParseException.class)
    public void testInstantationWithWrongDate() throws ParseException, MalformedURLException{
        new News("", "http://www.google.com", "Wed", "", "");
    }

    @Test
    public void testCorrectInstantation() throws ParseException, MalformedURLException{
        News news = new News("", "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", "", "");
        assertNotNull(news);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNulls() throws ParseException, MalformedURLException{
        new News(null, null, null, null, null);
    }

    @Test(expected = MalformedURLException.class)
    public void testWithWrongUrl() throws ParseException, MalformedURLException{
        News news = new News("", "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", "", "");
        news.setUrl("NyanCat");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNullUrl() throws ParseException, MalformedURLException{
        News news = new News("", null, "Wed, 26 Mar 2014 17:34:34 GMT", "", "");
    }

    @Test
    public void testEqualsWithDifferentClass() throws MalformedURLException, ParseException{
        News news1 = new News("", "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", "", "");
        assertFalse(news1.equals("banana"));
    }

    @Test
    public void  testEquals() throws MalformedURLException, ParseException {
        News news1 = new News("", "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", "", "");
        news1.setId(new Long(12));
        News news2 = new News("", "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", "", "");
        news2.setId(new Long(12));
        assertTrue(news1.equals(news2));

        news1 = new News("", "http://www.google.com/reader", "Wed, 26 Mar 2014 17:34:34 GMT", "", "");
        news1.setId(new Long(11));
        news2 = new News("", "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", "", "");
        news2.setId(new Long(12));
        assertFalse(news1.equals(news2));

        news1 = new News("", "http://www.google.com/reader", "Wed, 26 Mar 2014 17:34:34 GMT", "", "");
        news1.setId(new Long(11));
        news2 = new News("", "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", "", "");
        news2.setId(new Long(11));
        assertFalse(news1.equals(news2));

        news1 = new News("", "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", "hola", "");
        news1.setId(new Long(11));
        news2 = new News("", "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", "", "");
        news2.setId(new Long(11));
        assertFalse(news1.equals(news2));

        news1 = new News("", "http://www.google.com", "Wed, 27 Mar 2014 17:34:34 GMT", "", "");
        news1.setId(new Long(11));
        news2 = new News("", "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", "", "");
        news2.setId(new Long(11));
        assertFalse(news1.equals(news2));

        news1 = new News("", "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", "", "");
        news1.setId(new Long(11));
        news2 = new News("", "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", "", "hola");
        news2.setId(new Long(11));
        assertFalse(news1.equals(news2));
    }

    @Ignore
    @Test
    public void  testCompare() throws MalformedURLException, ParseException {
        News news1 = new News("", "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", "", "");
        news1.setId(new Long(12));
        News news2 = new News("", "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", "", "");
        news2.setId(new Long(12));
        assertTrue(news1.compareTo(news2)==0);

        news1 = new News("", "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", "", "");
        news2 = new News("", "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", "", "");
        news1.setId(new Long(1));
        news2.setId(new Long(12));
        assertTrue(news1.compareTo(news2)==-1);

        news1 = new News("", "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", "", "");
        news2 = new News("", "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", "", "");
        news1.setId(new Long(12));
        news2.setId(new Long(2));
        assertTrue(news1.compareTo(news2)==1);

        news1 = new News("", "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", "", "");
        news2 = new News("", "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", "", "");
        news2.setId(new Long(12));
        assertTrue(news1.compareTo(news2)==-1);

        news1 = new News("", "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", "", "");
        news2 = new News("", "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", "", "");
        news1.setId(new Long(12));
        assertTrue(news1.compareTo(news2)==1);

        news1 = new News("", "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", "", "img");
        news2 = new News("", "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", "", null);
        assertTrue(news1.compareTo(news2)==1);

        news1 = new News("", "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", "", null);
        news2 = new News("", "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", "", "img");
        assertTrue(news1.compareTo(news2)==-1);

        news1 = new News("", "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", "uno", null);
        news2 = new News("", "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", null, null);
        assertTrue(news1.compareTo(news2)==1);

        news1 = new News("", "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", null, null);
        news2 = new News("", "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", "uno", null);
        assertTrue(news1.compareTo(news2)==-1);

        news1 = new News("", "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", "uno", null);
        news2 = new News("", "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", "", null);
        assertTrue(news1.compareTo(news2)==1);

        news1 = new News("", "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", "", null);
        news2 = new News("", "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", "uno", null);
        assertTrue(news1.compareTo(news2)==-1);

        news1 = new News("1", "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", null, null);
        news2 = new News(null, "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", null, null);
        assertTrue(news1.compareTo(news2)==1);

        news1 = new News(null, "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", null, null);
        news2 = new News("1", "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", "uno", null);
        assertTrue(news1.compareTo(news2)==-1);

        news1 = new News("1", "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", null, null);
        news2 = new News("", "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", null, null);
        assertTrue(news1.compareTo(news2)==1);

        news1 = new News("", "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", null, null);
        news2 = new News("1", "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", null, null);
        assertTrue(news1.compareTo(news2)==-1);

        news1 = new News(null, "http://www.google.com", "Wed, 27 Mar 2014 17:34:34 GMT", null, null);
        news2 = new News(null, "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", null, null);
        assertTrue(news1.compareTo(news2)==1);

        news1 = new News(null, "http://www.google.com", "Wed, 26 Mar 2014 17:34:34 GMT", null, null);
        news2 = new News(null, "http://www.google.com", "Wed, 27 Mar 2014 17:34:34 GMT", null, null);
        assertTrue(news1.compareTo(news2)==-1);
    }


}
