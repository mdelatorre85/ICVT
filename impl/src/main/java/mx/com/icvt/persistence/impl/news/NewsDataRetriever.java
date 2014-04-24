package mx.com.icvt.persistence.impl.news;

import mx.com.icvt.model.News;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class NewsDataRetriever {
    private static SimpleDateFormat FORMAT;
    static {
        FORMAT = new SimpleDateFormat("EEE, dd MMM yyyy kk:mm:ss z", Locale.ENGLISH);
    }

    public List<News> retrieve(){
        List<News> noticias = new ArrayList<News>();
        String pubDate;
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
}
