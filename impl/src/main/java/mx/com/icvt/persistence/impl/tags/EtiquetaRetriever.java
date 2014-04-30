package mx.com.icvt.persistence.impl.tags;

import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class EtiquetaRetriever {
    private Logger logger = Logger.getLogger(EtiquetaRetriever.class);

    public List<Etiqueta> getAllPersisted() {
        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        Query query = manager.createQuery("SELECT t FROM Etiqueta t");
        List etiquetas = query.getResultList();
        manager.close();
        return etiquetas;
    }

    public Etiqueta getByValue(String valor) {
        Etiqueta result = null;
        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        Query query = manager.createQuery("SELECT t FROM Etiqueta t WHERE t.valor = :valor");
        query.setParameter("valor", valor);

        try {
            result = (Etiqueta) query.getSingleResult();
        } catch (NoResultException e){
            logger.warn("No se encontró la etiqueta con el valor " + valor);
        }

        return result;
    }

    public Etiqueta getById(Long id) {
        Etiqueta etiqueta;
        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        etiqueta = manager.find(Etiqueta.class, id);
        manager.close();
        return etiqueta;
    }
}
