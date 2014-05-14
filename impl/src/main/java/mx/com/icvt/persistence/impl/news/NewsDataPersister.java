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
        manager.close();

        return success;
    }

    @Override
    public void persist(NewsResultData rs) {
        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        manager.getTransaction().begin();

        NewsDataRetriever retriever = new NewsDataRetriever();
        News temp;

        List<Noticia> toPersist = new LinkedList<Noticia>();
        List<Noticia> toUpdate = new LinkedList<Noticia>();
        List<Noticia> toIgnore = new LinkedList<Noticia>();
        Noticia noticia;

        ConfiguracionExtraccionNoticias configuracion = manager.find(ConfiguracionExtraccionNoticias.class, rs.getConfiguration().getId());
        ExtraccionNoticias extraccionNoticias = new ExtraccionNoticias(rs.getStartDate(), rs.getEndDate(), configuracion);

        List<News> results = rs.getResults();
        for (News news : results) {
            temp = retriever.getByUrl(news.getUrl());
            if (temp != null){
                noticia = manager.find(Noticia.class, temp.getID());

                if (news.compareTo(temp) > 1){
                    noticia.setTitulo(news.getTitle());
                    noticia.setTitulo(news.getDescription());
                    noticia.setTitulo(news.getImage());
                    toUpdate.add(noticia);
                } else {
                    toIgnore.add(noticia);
                }
            } else {
                noticia = new Noticia(news);
                toPersist.add(noticia);
            }
        }

        for (Noticia entity : toPersist) {
            manager.persist(entity);
            extraccionNoticias.getNoticias().add(entity);
        }

        for (Noticia entity : toUpdate) {
            manager.merge(entity);
            extraccionNoticias.getNoticias().add(entity);
        }

        for (Noticia entity : toIgnore){
            extraccionNoticias.getNoticias().add(entity);
        }

        manager.persist(extraccionNoticias);

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
        for (Long idEtiqueta : idsEtiqueta){
            addLabel(idNoticia, idEtiqueta);
        }
    }

    public void addLabel(Long idNoticia, Long idEtiqueta) {
        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        manager.getTransaction().begin();

        Noticia noticia = manager.find(Noticia.class, idNoticia);
        Etiqueta etiqueta = manager.find(Etiqueta.class, idEtiqueta);

        boolean etiquetado = false;
        if (noticia != null && etiqueta != null){
            for (Etiqueta temp : noticia.getEtiquetas()){
                if (temp.getId().equals(idEtiqueta)){
                    etiquetado = true;
                }
            }

            if (!etiquetado){
                noticia.getEtiquetas().add(etiqueta);
                manager.merge(noticia);
            }
        }

        manager.getTransaction().commit();
        manager.close();
    }

    public List<Etiqueta> getLabels(Long idNoticia) {
        List<Etiqueta> etiquetas = new ArrayList<Etiqueta>();
        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        Noticia noticia = manager.find(Noticia.class, idNoticia);

        if (noticia != null){
            for (Etiqueta e : noticia.getEtiquetas()){
                etiquetas.add(new Etiqueta(e.getId(), e.getValor(), e.getColor()));
            }
        }

        manager.close();
        return etiquetas;
    }
}
