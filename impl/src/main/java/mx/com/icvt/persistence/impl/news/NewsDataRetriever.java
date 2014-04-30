package mx.com.icvt.persistence.impl.news;

import mx.com.icvt.model.News;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsDataRetriever {
    public List<News> retrieveAllEnabled() {
        List<News> results = new ArrayList<News>();
        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        Query query = manager.createQuery("SELECT n FROM Noticia n WHERE n.habilitada = true");

        List<Noticia> noticias = query.getResultList();
        for (Noticia noticia : noticias) {
            results.add(noticia.getNews());
        }

        manager.close();
        return results;
    }

    public News getById(Long idNoticia) {
        News news = null;
        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        Noticia noticia = manager.find(Noticia.class, idNoticia);
        if (noticia != null) {
            news = noticia.getNews();
        }

        manager.close();

        return news;
    }

    public List<News> getAllById(List<Long> ids) {
        List<News> news = new ArrayList<News>();
        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        Query query = manager.createQuery("SELECT n FROM Noticia n WHERE n.id IN :ids");
        query.setParameter("ids", ids);
        List<Noticia> results = query.getResultList();
        for (Noticia n : results) {
            news.add(n.getNews());
        }

        return news;
    }

    public News getByUrl(String url) {
        assert url != null && !url.equals("");

        News noticia = null;
        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        Query query = manager.createQuery("SELECT n FROM Noticia n where n.url = :url");
        query.setParameter("url", url);
        Noticia result;

        try {
            result = (Noticia) query.getSingleResult();
            noticia = result.getNews();
        } catch (NoResultException e) {
        }

        manager.close();
        return noticia;
    }

    public List<News> getAllEnabledByDate(Date beginDate, Date endDate) {
        assert beginDate != null && endDate != null;
        List<News> news = new ArrayList<News>();

        String sQuery = "SELECT n FROM Noticia n WHERE n.fechaPublicacion >= :beginDate ";
        sQuery += "AND n.fechaPublicacion <= :endDate ";

        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        Query query = manager.createQuery(sQuery);
        query.setParameter("beginDate", beginDate);
        query.setParameter("endDate", endDate);
        List<Noticia> noticias = query.getResultList();

        for (Noticia noticia : noticias) {
            if (noticia.isHabilitada()) {
                news.add(noticia.getNews());
            }
        }

        manager.close();

        return news;
    }
}
