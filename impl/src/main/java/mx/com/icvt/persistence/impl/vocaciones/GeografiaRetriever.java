package mx.com.icvt.persistence.impl.vocaciones;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class GeografiaRetriever {
    public List<Municipio> getMunicipios() {
        List<Municipio> municipios;

        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        Query query = manager.createQuery("Select m from Municipio m");
        municipios = query.getResultList();
        manager.close();

        return municipios;
    }

    public List<Localidad> getLocalidades() {
        List<Localidad> localidades;

        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        Query query = manager.createQuery("Select l from Localidad l");
        localidades = query.getResultList();

        manager.close();

        return localidades;
    }
}
