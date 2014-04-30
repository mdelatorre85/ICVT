package mx.com.icvt.persistence.impl.tweets;

import mx.com.icvt.extraction.impl.twitter.TwitterResultData;
import mx.com.icvt.model.Tweet;
import mx.com.icvt.persistence.DataResultPersister;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TweetsDataPersister implements DataResultPersister<TwitterResultData> {
    @Override
    public void persist(TwitterResultData rs) {
        List<DBTweet> tweets = new LinkedList<DBTweet>();
        List<Tweet> results = rs.getResults();

        for (Tweet tweet : results) {
            tweets.add(new DBTweet(tweet));
        }

        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        manager.getTransaction().begin();

        for (DBTweet tweet : tweets) {
            manager.persist(tweet);
        }

        manager.getTransaction().commit();
        manager.close();
    }

    public List<Tweet> getAllPersisted() {
        List<Tweet> tweets = new ArrayList<Tweet>();

        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        Query query = manager.createQuery("SELECT t FROM DBTweet t");
        List<DBTweet> list = query.getResultList();
        for (DBTweet dbTweet : list) {
            tweets.add(dbTweet.getTweet());
        }

        manager.close();
        return tweets;
    }

    public Long deleteAllPersisted() {
        int deleted;

        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        manager.getTransaction().begin();
        Query query = manager.createQuery("DELETE t FROM DBTweets t");
        deleted = query.executeUpdate();
        manager.getTransaction().commit();
        return (long) deleted;
    }
}
