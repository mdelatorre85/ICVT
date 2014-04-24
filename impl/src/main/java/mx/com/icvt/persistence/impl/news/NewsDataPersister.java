package mx.com.icvt.persistence.impl.news;

import mx.com.icvt.extraction.impl.news.NewsResultData;
import mx.com.icvt.model.News;
import mx.com.icvt.persistence.DataResultPersister;

import javax.jdo.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class NewsDataPersister implements DataResultPersister<NewsResultData> {
    @Override
    public void persist(NewsResultData rs) {
        List<Noticia> noticias = new LinkedList<Noticia>();
        Noticia noticia;

        List<News> results = rs.getResults();
        for (News news : results){
            noticia = new Noticia();
            noticia.setUrl(news.getUrl());
            noticia.setTitulo(news.getTitle());
            noticia.setDescripcion(news.getDescription());
            noticia.setFechaPublicacion(news.getPubDate());
            noticia.setUrlImagen(news.getImage());
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

        transaction.commit();
        persistenceManager.close();

        return deleted;
    }
}
