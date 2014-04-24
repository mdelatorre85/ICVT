package mx.com.icvt.persistence.impl.tweets;

import mx.com.icvt.extraction.impl.twitter.TwitterResultData;
import mx.com.icvt.model.Tweet;
import mx.com.icvt.persistence.DataResultPersister;
import mx.com.icvt.persistence.impl.news.Noticia;

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
        List<Tweet> results = rs.getResults();

        for (Tweet tweet : results){
            tweets.add(new DBTweet(tweet));
        }

        Transaction transaction = manager.currentTransaction();

        transaction.begin();

        for (DBTweet tweet : tweets){
            manager.makePersistent(tweet);
        }

        transaction.commit();
        manager.close();
    }

    public List<Tweet> getAllPersisted(){
        List<Tweet> tweets = new ArrayList<Tweet>();

        PersistenceManagerFactory factory = JDOHelper.getPersistenceManagerFactory("SITE");
        PersistenceManager manager = factory.getPersistenceManager();
        Query query = manager.newQuery(DBTweet.class);
        query.setResultClass(DBTweet.class);
        Collection<DBTweet> dbTweets = (Collection<DBTweet>) query.execute();
        for (DBTweet dbTweet: dbTweets){
            tweets.add(dbTweet.getTweet());
        }

        return tweets;
    }

    public Long deleteAllPersisted(){
        Long deleted;

        PersistenceManagerFactory factory = JDOHelper.getPersistenceManagerFactory("SITE");
        PersistenceManager manager = factory.getPersistenceManager();
        manager.currentTransaction().begin();

        Query query = manager.newQuery(Noticia.class);
        deleted = query.deletePersistentAll();

        manager.currentTransaction().commit();

        return deleted;
    }
}
