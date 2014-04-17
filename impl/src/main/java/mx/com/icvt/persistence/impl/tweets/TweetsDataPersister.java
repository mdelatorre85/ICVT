package mx.com.icvt.persistence.impl.tweets;

import mx.com.icvt.extraction.impl.twitter.TwitterResultData;
import mx.com.icvt.model.Tweet;
import mx.com.icvt.persistence.DataResultPersister;

import javax.jdo.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class TweetsDataPersister implements DataResultPersister<TwitterResultData>{
    @Override
    public void persist(TwitterResultData rs){
        PersistenceManagerFactory factory = JDOHelper.getPersistenceManagerFactory("SITE");
        PersistenceManager manager = factory.getPersistenceManager();

        List<DBTweet> tweets = new LinkedList<DBTweet>();
        ArrayList<Tweet> results = rs.getResults();

        for (Tweet tweet : results){
            tweets.add(modelTransformer(tweet));
        }

        Transaction transaction = manager.currentTransaction();

        transaction.begin();

        for (DBTweet tweet : tweets){
            manager.makePersistent(tweet);
        }

        transaction.commit();
        manager.close();
    }

    public static DBTweet modelTransformer(Tweet tweet){
        DBTweet dbTweet = new DBTweet();
        dbTweet.setTexto(tweet.getText());
        dbTweet.setUrl(tweet.getUrl());
        dbTweet.setFechaPublicacion(tweet.getPubDate());
        dbTweet.setUrl(tweet.getUrl());
        dbTweet.setLatitud(tweet.getLatitude());
        dbTweet.setLongitud(tweet.getLongitude());
        dbTweet.setNumeroRetweets(tweet.getRetweetCount());
        dbTweet.setNumeroFavoritos(tweet.getFavoriteCount());
        dbTweet.setId(tweet.getUserID());
        dbTweet.setAliasUsuario(tweet.getUserScreenName());
        dbTweet.setNombreUsuario(tweet.getUserName());
        dbTweet.setUrlPerfilUsuario(tweet.getUserProfileUrl());
        return dbTweet;
    }

    public List<Tweet> getAllPersisted(){
        List<Tweet> tweets = new ArrayList<Tweet>();
        Tweet tweet;

        PersistenceManagerFactory factory = JDOHelper.getPersistenceManagerFactory("SITE");
        PersistenceManager manager = factory.getPersistenceManager();
        Query query = manager.newQuery(DBTweet.class);
        query.setResultClass(DBTweet.class);
        Collection<DBTweet> dbTweets = (Collection<DBTweet>) query.execute();
        for (DBTweet dbTweet: dbTweets){
            //TODO Convert dbTweet to tweet
        }

        return tweets;
    }
}
