package mx.com.icvt.persistence.impl.tweets;

import mx.com.icvt.extraction.impl.twitter.TwitterResultData;
import mx.com.icvt.model.Tweet;
import mx.com.icvt.persistence.DataResultPersister;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

public class TweetsDataPersister implements DataResultPersister<TwitterResultData> {
    public boolean persist(ConfiguracionExtraccionTweets configuracion) {
        boolean success = false;

        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        manager.getTransaction().begin();

        try {
            manager.persist(configuracion);
            success = true;
        } catch (EntityExistsException ignored) {
        } catch (PersistenceException ignored) {
        }

        manager.getTransaction().commit();
        manager.close();

        return success;
    }

    @Override
    public void persist(TwitterResultData rs) {
        DBTweet tweet;

        ExtraccionTweets extraccionTweets;
        ConfiguracionExtraccionTweets configuracion;
        List<Tweet> results;

        results = rs.getResults();
        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        manager.getTransaction().begin();

        configuracion = manager.find(ConfiguracionExtraccionTweets.class, rs.getConfiguration().getId());
        assert configuracion != null;
        extraccionTweets = new ExtraccionTweets(rs.getStartDate(), rs.getEndDate(), configuracion);

        for (Tweet t : results) {
            tweet = manager.find(DBTweet.class, t.getId());

            if (tweet == null) {
                tweet = new DBTweet(t);
                manager.persist(tweet);
            }

            extraccionTweets.getTweets().add(tweet);
        }

        manager.persist(extraccionTweets);
        manager.getTransaction().commit();
        manager.close();
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
