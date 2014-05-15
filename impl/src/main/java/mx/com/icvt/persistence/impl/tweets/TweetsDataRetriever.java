package mx.com.icvt.persistence.impl.tweets;

import mx.com.icvt.model.Tweet;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Date;
import java.util.LinkedList;
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

    public List<Tweet> getRecent(int limite) {
        if (limite < 0) {
            throw new IllegalArgumentException("El parámetro límite no puede ser menor de 0");
        }

        List<Tweet> tweets = new LinkedList<Tweet>();

        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        Query query = manager.createNamedQuery("getRecentTweets");
        query.setMaxResults(limite);
        List<DBTweet> results = query.getResultList();

        for (DBTweet t : results) {
            tweets.add(t.getTweet());
        }

        manager.close();

        return tweets;
    }

    public List<Tweet> getByDate(Date inicio, Date fin, int límite) {
        if (límite < 0) {
            throw new IllegalArgumentException("El parámetro límite no puede ser menor de 0");
        }

        List<Tweet> tweets = new LinkedList<Tweet>();

        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        Query query = manager.createNamedQuery("getTweetsByDate");
        query.setParameter("inicio", inicio);
        query.setParameter("fin", fin);
        query.setMaxResults(límite);
        List<DBTweet> results = query.getResultList();
        for (DBTweet t : results) {
            tweets.add(t.getTweet());
        }

        manager.close();

        return tweets;
    }
}
