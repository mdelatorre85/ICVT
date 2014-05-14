package mx.com.icvt.persistence.impl.news;

import mx.com.icvt.model.News;
import mx.com.icvt.persistence.impl.tags.Etiqueta;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class NewsDataRetriever {
    public List<ConfiguracionExtraccionNoticias> getAllConfigurations(){
        List<ConfiguracionExtraccionNoticias> configuraciones;

        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        Query query = manager.createQuery("Select c from ConfiguracionExtraccionNoticias c");
        configuraciones = query.getResultList();
        manager.close();

        return configuraciones;
    }

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
        sQuery += "AND n.fechaPublicacion <= :endDate ORDER BY n.fechaPublicacion DESC";

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

    public List<News> getAllEnabledByDate(Date endDate){
        assert endDate != null;
        List<News> news = new ArrayList<News>();

        String sQuery = "SELECT n FROM Noticia n WHERE n.fechaPublicacion <= :endDate ORDER BY n.fechaPublicacion DESC";

        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        Query query = manager.createQuery(sQuery);
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

    public List<News> getAllEnabledByLabel(Long labelId){
        List<News> news = new LinkedList<News>();

        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        Etiqueta etiqueta = manager.find(Etiqueta.class, labelId);

        if (etiqueta != null){
            List<Noticia> noticias = etiqueta.getNoticias();

            for (Noticia noticia : noticias){
                news.add(noticia.getNews());
            }
        }

        manager.close();

        return news;
    }

    public List<News> getAllEnabledByLabels(List<Long> idLabels){
        assert !idLabels.isEmpty();

        List<News> news = new LinkedList<News>();
        String ids = "";

        for (Long id : idLabels){
            ids += id + ",";
        }

        ids = ids.substring(0, ids.length() - 1);
        System.out.printf("Ids to search: %s\n", ids);

        StringBuilder select = new StringBuilder();
        select.append("select * from Noticias where id in ");
        select.append("(select distinct(ne.id_noticia) from noticia_tiene_etiquetas ne, etiquetas e ");
        select.append("where ne.id_etiqueta = e.id and e.id in (");
        select.append(ids);
        select.append("))");

        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        Query query = manager.createNativeQuery(select.toString(), Noticia.class);
        List<Noticia> resultList = query.getResultList();

        for (Noticia n : resultList){
            news.add(n.getNews());
        }

        manager.close();

        return news;
    }

    public List<News> getAllEnabledByLabelsAndDate(List<Long> idLabels, Date inicio, Date fin){
        assert !idLabels.isEmpty();
        assert inicio != null;
        assert fin != null;

        List<News> news = new LinkedList<News>();
        String ids = "";

        for (Long id : idLabels){
            ids += id + ",";
        }

        ids = ids.substring(0, ids.length() - 1);
        System.out.printf("Ids to search: %s\n", ids);

        StringBuilder select = new StringBuilder();
        select.append("select * from Noticias where id in ");
        select.append("(select distinct(ne.id_noticia) from noticia_tiene_etiquetas ne, etiquetas e ");
        select.append("where ne.id_etiqueta = e.id and e.id in (");
        select.append(ids);
        select.append(")) && fecha_publicacion >= ?1 && fecha_publicacion <= ?2");

        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        Query query = manager.createNativeQuery(select.toString(), Noticia.class);
        query.setParameter(1, inicio);
        query.setParameter(2, fin);
        List<Noticia> resultList = query.getResultList();

        for (Noticia n : resultList){
            news.add(n.getNews());
        }

        manager.close();

        return news;
    }
}