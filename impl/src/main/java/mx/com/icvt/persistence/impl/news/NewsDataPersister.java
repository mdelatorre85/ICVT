package mx.com.icvt.persistence.impl.news;

import mx.com.icvt.extraction.impl.news.NewsResultData;
import mx.com.icvt.model.News;
import mx.com.icvt.persistence.DataResultPersister;
import mx.com.icvt.persistence.impl.tags.Etiqueta;
import mx.com.icvt.persistence.impl.tags.EtiquetaPersister;

import javax.jdo.*;
import javax.jdo.annotations.PersistenceAware;
import java.util.*;

@PersistenceAware
public class NewsDataPersister implements DataResultPersister<NewsResultData> {
    @Override
    public void persist(NewsResultData rs) {
        List<Noticia> noticias = new LinkedList<Noticia>();
        Noticia noticia;

        List<News> results = rs.getResults();
        for (News news : results){
            noticia = new Noticia(news);
            noticias.add(noticia);
        }

        PersistenceManagerFactory factory = JDOHelper.getPersistenceManagerFactory("SITE");
        PersistenceManager persistenceManager = factory.getPersistenceManager();
        Transaction transaction = persistenceManager.currentTransaction();
        transaction.begin();

        for (Noticia n : noticias){
            persistenceManager.makePersistent(n);
        }

        transaction.commit();
        persistenceManager.close();
    }

    public Long deleteAllPersisted(){
        Long deleted;

        PersistenceManagerFactory factory = JDOHelper.getPersistenceManagerFactory("SITE");
        PersistenceManager persistenceManager = factory.getPersistenceManager();
        Transaction transaction = persistenceManager.currentTransaction();
        transaction.begin();

        Query query = persistenceManager.newQuery(Noticia.class);
        deleted = query.deletePersistentAll();

        query = persistenceManager.newQuery(NoticiaEtiqueta.class);
        query.deletePersistentAll();

        transaction.commit();
        persistenceManager.close();

        return deleted;
    }

    public void addLabel(Long idNoticia, Long idEtiqueta){
        NoticiaEtiqueta noticiaEtiqueta = new NoticiaEtiqueta(idNoticia, idEtiqueta);
        PersistenceManagerFactory factory = JDOHelper.getPersistenceManagerFactory("SITE");
        PersistenceManager manager = factory.getPersistenceManager();
        manager.currentTransaction().begin();
        manager.makePersistent(noticiaEtiqueta);
        manager.currentTransaction().commit();
    }

    public List<Etiqueta> getLabels(Long idNoticia){
        List<Etiqueta> etiquetas = new ArrayList<Etiqueta>();

        PersistenceManagerFactory factory = JDOHelper.getPersistenceManagerFactory("SITE");
        PersistenceManager manager = factory.getPersistenceManager();
        Query query = manager.newQuery(NoticiaEtiqueta.class);
        query.setFilter("idNoticia == idNoticia");
        query.declareParameters("Long idNoticia");
        List<NoticiaEtiqueta> labels = (List<NoticiaEtiqueta>) query.execute(idNoticia);

        EtiquetaPersister persister = new EtiquetaPersister();

        Long idEtiqueta;
        Etiqueta etiqueta;
        for (NoticiaEtiqueta ne : labels){
            idEtiqueta = ne.getIdEtiqueta();
            etiqueta = persister.getById(idEtiqueta);

            if (etiqueta != null){
                etiquetas.add(etiqueta);
            }
        }

        manager.close();

        return etiquetas;
    }
}
