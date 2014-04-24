package mx.com.icvt.persistence.impl.tweets;

import mx.com.icvt.extraction.impl.twitter.TwitterResultData;
import mx.com.icvt.model.Tweet;

import java.util.ArrayList;
import java.util.List;

public class TweetsDataPersisterTest {
    private TwitterResultData crearTwitterResultData(){
        TwitterResultData resultData = new TwitterResultData(){
            @Override
            public List<Tweet> getResults(){
                List<Tweet> tweets = new ArrayList<Tweet>();

                return tweets;
            }
        };

        return resultData;
    }
}
