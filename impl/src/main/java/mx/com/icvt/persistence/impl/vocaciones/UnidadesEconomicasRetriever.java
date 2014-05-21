package mx.com.icvt.persistence.impl.vocaciones;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class UnidadesEconomicasRetriever {
    private UnidadEconomica getUnidadEconomica(int id) {
        UnidadEconomica unidadEconomica;

        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        unidadEconomica = manager.find(UnidadEconomica.class, id);
        manager.close();

        return unidadEconomica;
    }
}
