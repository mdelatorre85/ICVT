package mx.com.icvt.persistence.impl.vocaciones;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ClaseActividadRetriever {
    public List<ClaseActividad> getAll(){
        List<ClaseActividad> clasesActividad;

        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        Query query = manager.createQuery("Select c from ClaseActividad c");
        clasesActividad = query.getResultList();
        manager.close();

        return clasesActividad;
    }
}
