package mx.com.icvt.persistence.impl.tags;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class EtiquetaPersister {
    public void persist(Etiqueta etiqueta) {
        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        manager.getTransaction().begin();
        manager.persist(etiqueta);
        manager.getTransaction().commit();
        manager.close();
    }

    public Long getIdByValue(String valorEtiqueta) {
        Long id = null;
        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        Query query = manager.createQuery("SELECT t FROM Etiqueta t WHERE t.valor = :valor");
        query.setParameter("valor", valorEtiqueta);

        try {
            Etiqueta result = (Etiqueta) query.getSingleResult();
            id = result.getId();
        } catch (NoResultException e) {
        }

        manager.close();

        return id;
    }

    public Etiqueta getById(Long idEtiqueta) {
        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        Etiqueta etiqueta = manager.find(Etiqueta.class, idEtiqueta);
        manager.close();
        return etiqueta;
    }
}
