package mx.com.icvt.model;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by miguelangeldelatorre on 05/05/14.
 */
public class TweetTest {
    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void testWrongInstantationNullStatus(){
        new Tweet(null);
    }

}
