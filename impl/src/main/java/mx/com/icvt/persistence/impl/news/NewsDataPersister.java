package mx.com.icvt.persistence.impl.news;

import mx.com.icvt.extraction.ResultData;
import mx.com.icvt.model.News;
import mx.com.icvt.persistence.DataResultPersister;

import javax.jdo.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class NewsDataPersister implements DataResultPersister {
    private static SimpleDateFormat FORMAT;
    static {
        FORMAT = new SimpleDateFormat("EEE, dd MMM yyyy kk:mm:ss z", Locale.ENGLISH);
    }

    @Override
    public void persist(ResultData rs) {
        List<Noticia> noticias = new LinkedList<Noticia>();
        Noticia noticia;

        ArrayList<News> results = (ArrayList<News>) rs.getResults();
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

    public List<News> getAllPersisted(){
        List<News> noticias = new ArrayList<News>();
        String pubDate = "";
        News news;

        PersistenceManagerFactory factory = JDOHelper.getPersistenceManagerFactory("SITE");
        PersistenceManager persistenceManager = factory.getPersistenceManager();
        Query query = persistenceManager.newQuery(Noticia.class);
        query.setResultClass(Noticia.class);

        Collection<Noticia> results = (Collection<Noticia>)query.execute();
        for (Noticia n : results){
            pubDate = FORMAT.format(n.getFechaPublicacion());

            try {
                news = new News(n.getTitulo(), n.getUrl(), pubDate, n.getDescripcion(), "");
                news.setId(n.getId());
                noticias.add(news);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return noticias;
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
