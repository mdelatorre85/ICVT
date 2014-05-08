package mx.com.icvt.persistence.impl.news;

import mx.com.icvt.extraction.impl.news.NewsResultData;
import mx.com.icvt.model.News;
import mx.com.icvt.persistence.DataResultPersister;
import mx.com.icvt.persistence.impl.tags.Etiqueta;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NewsDataPersister implements DataResultPersister<NewsResultData> {
    public boolean persist(ConfiguracionExtraccionNoticias configuracion){
        boolean success = false;

        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        manager.getTransaction().begin();

        try {
            manager.persist(configuracion);
            success = true;
        } catch (EntityExistsException ignored){
        } catch (PersistenceException ignored){
        }

        manager.getTransaction().commit();

        return success;
    }

    public List<ConfiguracionExtraccionNoticias> getAllConfigurations(){
        List<ConfiguracionExtraccionNoticias> configuraciones;

        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        Query query = manager.createQuery("Select c from ConfiguracionExtraccionNoticias c");
        configuraciones = query.getResultList();
        manager.close();

        return configuraciones;
    }

    public List<ConfiguracionExtraccionNoticias> getConfigurationForActivityClass(Long idActivityClass){
        List<ConfiguracionExtraccionNoticias> configuraciones;

        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        Query query = manager.createQuery("Select c from ConfiguracionExtraccionNoticias c where id_clase_actividad = :id");
        query.setParameter("id", idActivityClass);
        configuraciones = query.getResultList();
        manager.close();

        return configuraciones;
    }

    @Override
    public void persist(NewsResultData rs) {
        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        manager.getTransaction().begin();

        NewsDataRetriever retriever = new NewsDataRetriever();
        News temp;

        List<Noticia> toPersist = new LinkedList<Noticia>();
        Noticia noticia;

        List<News> results = rs.getResults();
        for (News news : results) {
            temp = retriever.getByUrl(news.getUrl());
            if (temp != null){
                int i = news.compareTo(temp);
                if (i > 0){

                }
            } else {
                noticia = new Noticia(news);
                toPersist.add(noticia);
            }
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
