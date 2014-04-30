package mx.com.icvt.persistence.impl.patents;

import mx.com.icvt.extraction.impl.patents.PatentsResultData;
import mx.com.icvt.model.Patent;
import mx.com.icvt.persistence.DataResultPersister;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PatentsDataPersister implements DataResultPersister<PatentsResultData> {
    @Override
    public void persist(PatentsResultData data) {
        List<Patent> results = data.getResults();
        List<DBPatent> patents = new LinkedList<DBPatent>();
        for (Patent result : results) {
            patents.add(new DBPatent(result));
        }

        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        manager.getTransaction().begin();

        for (DBPatent patent : patents) {
            manager.persist(patent);
        }

        manager.getTransaction().commit();
        manager.close();
    }

    public List<Patent> getAllPersisted() {
        List<Patent> patents = new ArrayList<Patent>();

        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        Query query = manager.createQuery("SELECT p FROM DBPatent p");
        List<DBPatent> results = query.getResultList();

        for (DBPatent patent : results) {
            patents.add(patent.getPatent());
        }
        manager.close();

        return patents;
    }

    public Long deleteAllPersisted() {
        int deleted;

        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        manager.getTransaction().begin();
        Query query = manager.createQuery("DELETE p FROM DBPatent p");
        deleted = query.executeUpdate();
        manager.getTransaction().commit();

        return (long) deleted;
    }
}
