package mx.com.icvt.persistence.impl.news;

import mx.com.icvt.model.News;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.annotations.PersistenceAware;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@PersistenceAware
public class NewsDataRetriever {
    public List<News> retrieveAllEnabled(){
        List<News> noticias = new ArrayList<News>();
        PersistenceManagerFactory factory = JDOHelper.getPersistenceManagerFactory("SITE");
        PersistenceManager manager = factory.getPersistenceManager();
        Query query = manager.newQuery(Noticia.class);
        List<Noticia> results = (List<Noticia>)query.execute();

        for (Noticia n : results){
            if (n.isHabilitada()){
                noticias.add(n.getNews());
            }
        }

        manager.close();
        return noticias;
    }

    public News getById(Long idNoticia){
        News news = null;
        PersistenceManagerFactory factory = JDOHelper.getPersistenceManagerFactory("SITE");
        PersistenceManager manager = factory.getPersistenceManager();
        Query query = manager.newQuery(Noticia.class);
        query.setFilter("id == idNoticia");
        query.declareParameters("Long idNoticia");
        query.setUnique(true);
        query.setResultClass(Noticia.class);

        Noticia noticia = (Noticia) query.execute(idNoticia);
        if (noticia != null){
            news = noticia.getNews();
        }

        manager.close();

        return news;
    }

    public List<News> getAllById(List<Long> ids){
        List<News> news = new ArrayList<News>();
        News noticia;

        for (Long id : ids){
            noticia = getById(id);
            if (noticia != null){
                news.add(noticia);
            }
        }

        return news;
    }

    public News getByUrl(String url){
        assert url != null && !url.equals("");

        News news = null;

        PersistenceManagerFactory factory = JDOHelper.getPersistenceManagerFactory("SITE");
        PersistenceManager manager = factory.getPersistenceManager();

        Query query = manager.newQuery(Noticia.class);
        query.setFilter("url == urlNoticia");
        query.declareImports("import java.lang.String");
        query.declareParameters("String urlNoticia");
        query.setUnique(true);

        Noticia noticia = (Noticia) query.execute(url);

        if (noticia != null){
            news = noticia.getNews();
        }

        manager.close();

        return news;
    }

    public List<News> getAllEnabledByDate(Date beginDate, Date endDate){
        assert beginDate != null && endDate != null;
        List<News> news = new ArrayList<News>();


        PersistenceManagerFactory factory = JDOHelper.getPersistenceManagerFactory("SITE");
        PersistenceManager manager = factory.getPersistenceManager();

        Query query = manager.newQuery(Noticia.class);
        query.setFilter("fechaPublicacion >= beginDate && fechaPublicacion <= endDate");
        query.declareImports("import java.util.Date");
        query.declareParameters("java.util.Date beginDate, java.util.Date endDate");

        List<Noticia> noticias = (List<Noticia>) query.execute(beginDate, endDate);
        for (Noticia noticia : noticias){
            if (noticia.isHabilitada()){
                news.add(noticia.getNews());
            }
        }

        manager.close();

        return news;
    }
}
