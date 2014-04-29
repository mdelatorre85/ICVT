package mx.com.icvt.persistence.impl.tags;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.annotations.PersistenceAware;

@PersistenceAware
public class EtiquetaPersister {
    public void persist(Etiqueta etiqueta) {
        PersistenceManagerFactory factory = JDOHelper.getPersistenceManagerFactory("SITE");
        PersistenceManager manager = factory.getPersistenceManager();
        manager.currentTransaction().begin();
        manager.makePersistent(etiqueta);
        manager.currentTransaction().commit();
    }

    public Long getIdByValue(String valorEtiqueta) {
        Long id = null;
        PersistenceManagerFactory factory = JDOHelper.getPersistenceManagerFactory("SITE");
        PersistenceManager manager = factory.getPersistenceManager();
        Query query = manager.newQuery(Etiqueta.class);
        query.setFilter("valor == valorEtiqueta");
        query.declareParameters("String valorEtiqueta");
        query.setResultClass(Etiqueta.class);
        query.setUnique(true);
        Etiqueta etiqueta = (Etiqueta) query.execute(valorEtiqueta);

        if (etiqueta != null){
            id = etiqueta.getId();
        }

        manager.close();

        return id;
    }

    public Etiqueta getById(Long idEtiqueta){
        PersistenceManagerFactory factory = JDOHelper.getPersistenceManagerFactory("SITE");
        PersistenceManager manager = factory.getPersistenceManager();
        Query query = manager.newQuery(Etiqueta.class);
        query.setFilter("id == idEtiqueta");
        query.declareParameters("Long idEtiqueta");
        query.setUnique(true);
        Etiqueta etiqueta = (Etiqueta) query.execute(idEtiqueta);
        manager.close();
        return etiqueta;
    }
}
