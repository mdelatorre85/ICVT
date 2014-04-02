package mx.com.icvt.extraction.impl.twitter;

import mx.com.icvt.extraction.DataExtractor;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;

/**
 * Created by miguelangeldelatorre on 01/04/14.
 */
public class TwitterDataExtractor implements DataExtractor<TwitterExtractorConfiguration,TwitterResultData> {


    @Override
    public TwitterResultData extract(TwitterExtractorConfiguration extractorConfiguration) {
        return null;
    }


    public static void main (String[] args){


        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("VuyeYsVkT5kK8aYYGNmHGKumR")
                .setOAuthConsumerSecret("n4qrALCQuaCZFOUAcOpU3XJuMoTdwHJeVL7GjLp8lfT2VDFYgc")
                .setOAuthAccessToken("84208180-KOrNy8Pr4SFnmWAGfgtZmKiiWgXoGIZtX7KsIwyDj")
                .setOAuthAccessTokenSecret("z7PH5jrfo820zUiCC0V93a5gRSqVU2qzTWZ3lpsUImT36");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        try {
            Query query = new Query("Chile");
            QueryResult result;
            do {
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets) {
                    System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
                }
            } while ((query = result.nextQuery()) != null);
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }


        /*
        TwitterExtractorConfiguration config = new TwitterExtractorConfiguration();
        new TwitterDataExtractor().extract(config);*/

    }
}
