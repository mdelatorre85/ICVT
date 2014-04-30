package mx.com.icvt.persistence.impl.news;

import mx.com.icvt.extraction.impl.news.NewsResultData;
import mx.com.icvt.model.News;
import mx.com.icvt.persistence.DataResultPersister;
import mx.com.icvt.persistence.impl.tags.Etiqueta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NewsDataPersister implements DataResultPersister<NewsResultData> {
    @Override
    public void persist(NewsResultData rs) {
        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        manager.getTransaction().begin();

        List<Noticia> toPersist = new LinkedList<Noticia>();
        Noticia noticia;

        List<News> results = rs.getResults();
        for (News news : results) {
            noticia = new Noticia(news);
            toPersist.add(noticia);
        }

        for (Noticia entity : toPersist) {
            manager.persist(entity);
        }

        manager.getTransaction().commit();
        manager.close();
    }

    public Long deleteAllPersisted() {
        int deleted;

        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        manager.getTransaction().begin();

        Query query = manager.createQuery("DELETE FROM Noticia n");
        deleted = query.executeUpdate();

        manager.getTransaction().commit();

        return (long) deleted;
    }

    public void addLabels(Long idNoticia, List<Long> idsEtiqueta) {
        Persistence.createEntityManagerFactory("SITE").createEntityManager();
    }

    public void addLabel(Long idNoticia, Long idEtiqueta) {

    }

    public List<Etiqueta> getLabels(Long idNoticia) {
        List<Etiqueta> etiquetas = new ArrayList<Etiqueta>();
        return etiquetas;
    }
}
