package mx.com.icvt.persistence.impl.tweets;

import mx.com.icvt.model.Tweet;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class TweetsDataRetriever {
    public List<ConfiguracionExtraccionTweets> getAllConfigurations() {
        List<ConfiguracionExtraccionTweets> configuraciones;

        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        Query query = manager.createQuery("Select c from ConfiguracionExtraccionTweets c");
        configuraciones = query.getResultList();
        manager.close();

        return configuraciones;
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
}
