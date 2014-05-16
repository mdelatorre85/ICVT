package mx.com.icvt.extraction.impl.twitter;

import mx.com.icvt.extraction.DataExtractor;
import mx.com.icvt.model.Tweet;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.Date;
import java.util.List;

/**
 * Created by miguelangeldelatorre on 01/04/14.
 */
public class TwitterDataExtractor implements DataExtractor<TwitterExtractorConfiguration, TwitterResultData> {
    @Override
    public TwitterResultData extract(TwitterExtractorConfiguration configuration) {
        TwitterResultData retorno = new TwitterResultData();

        if (configuration == null) {
            throw new IllegalArgumentException("Parameter extractorConfiguration cannot be null");
        }

        retorno.setConfiguration(configuration);
        retorno.setStartDate(new Date());
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("VuyeYsVkT5kK8aYYGNmHGKumR")
                .setOAuthConsumerSecret("n4qrALCQuaCZFOUAcOpU3XJuMoTdwHJeVL7GjLp8lfT2VDFYgc")
                .setOAuthAccessToken("84208180-KOrNy8Pr4SFnmWAGfgtZmKiiWgXoGIZtX7KsIwyDj")
                .setOAuthAccessTokenSecret("z7PH5jrfo820zUiCC0V93a5gRSqVU2qzTWZ3lpsUImT36");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        switch (configuration.getTwitterSearchKind()) {
            case USERTIMELINE:
                try {
                    List<Status> statuses = twitter.getUserTimeline(configuration.getQuery());

                    for (Status status : statuses) {
                        retorno.getResults().add(new Tweet(status));
                    }
                } catch (TwitterException te) {
                    te.printStackTrace();
                }
                break;
            case SEARCHQUERY:
                try {
                    Query query = new Query(configuration.getQuery());
                    if (configuration.getResultType() != null) {
                        query.setResultType(configuration.getResultType());
                    }
                    query.setCount(configuration.getCount());
                    if (configuration.getDateStartString() != null) {
                        query.setSince(configuration.getDateStartString());
                    }
                    if (configuration.getDateEndString() != null) {
                        query.setUntil(configuration.getDateEndString());
                    }
                    QueryResult result;
                    result = twitter.search(query);
                    List<Status> tweets = result.getTweets();
                    for (Status tweet : tweets) {
                        retorno.getResults().add(new Tweet(tweet));
                    }
                } catch (TwitterException te) {
                    te.printStackTrace();
                }

                break;
        }
        retorno.setEndDate(new Date());
        return retorno;
    }

    public static void main(String[] args) {
        TwitterExtractorConfiguration config = new TwitterExtractorConfiguration("mdelatorre85", TwitterExtractorConfiguration.TwitterSearchKind.USERTIMELINE);
        TwitterDataExtractor extractor = new TwitterDataExtractor();
        TwitterResultData results = extractor.extract(config);
        System.out.println(results.getResults().size());
    }
}
