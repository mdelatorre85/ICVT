package mx.com.icvt.persistence.impl.patents;

import mx.com.icvt.extraction.impl.patents.PatentsResultData;
import mx.com.icvt.model.Patent;
import mx.com.icvt.persistence.DataResultPersister;

import javax.jdo.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class PatentsDataPersister implements DataResultPersister<PatentsResultData> {
    @Override
    public void persist(PatentsResultData data) {
        List<Patent> results = data.getResults();
        List<DBPatent> patents = new LinkedList<DBPatent>();
        for (Patent result : results){
            patents.add(new DBPatent(result));
        }

        PersistenceManagerFactory factory = JDOHelper.getPersistenceManagerFactory("SITE");
        PersistenceManager manager = factory.getPersistenceManager();
        Transaction transaction = manager.currentTransaction();
        transaction.begin();

        for (DBPatent patent : patents){
            manager.makePersistent(patent);
        }

        transaction.commit();
        manager.close();
    }

    public List<Patent> getAllPersisted(){
        List<Patent> patents = new ArrayList<Patent>();

        PersistenceManagerFactory factory = JDOHelper.getPersistenceManagerFactory("SITE");
        PersistenceManager manager = factory.getPersistenceManager();
        Query query = manager.newQuery(DBPatent.class);
        Collection<DBPatent> results = (Collection<DBPatent>)query.execute();
        for (DBPatent patent : results){
            patents.add(patent.getPatent());
        }

        return patents;
    }

    public Long deleteAllPersisted(){
        Long deleted;

        PersistenceManagerFactory factory = JDOHelper.getPersistenceManagerFactory("SITE");
        PersistenceManager manager = factory.getPersistenceManager();
        manager.currentTransaction().begin();

        Query query = manager.newQuery(DBPatent.class);
        deleted = query.deletePersistentAll();

        manager.currentTransaction().commit();

        return deleted;
    }
}
