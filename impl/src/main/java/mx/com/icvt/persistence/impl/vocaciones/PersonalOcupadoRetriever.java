package mx.com.icvt.persistence.impl.vocaciones;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class PersonalOcupadoRetriever {
    public List<PersonalOcupado> getAll(){
        List<PersonalOcupado> personalOcupado;

        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        Query query = manager.createQuery("Select p from PersonalOcupado p");
        personalOcupado = query.getResultList();
        manager.close();

        return personalOcupado;
    }
}
