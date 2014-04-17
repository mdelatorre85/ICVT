package mx.com.icvt.persistence.impl.patents;

import mx.com.icvt.extraction.impl.patents.PatentsResultData;
import mx.com.icvt.model.Patent;
import mx.com.icvt.persistence.DataResultPersister;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;
import java.util.LinkedList;
import java.util.List;

public class PatentsDataPersister implements DataResultPersister<PatentsResultData> {
    @Override
    public void persist(PatentsResultData data) {
        List<Patent> results = data.getResults();
        List<DBPatent> patents = new LinkedList<DBPatent>();
        for (Patent result : results){
            patents.add(modelTransformer(result));
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

    private static DBPatent modelTransformer(Patent patent) {
        assert patent != null;

        DBPatent dbPatent = new DBPatent();
        StringBuilder autores = new StringBuilder();

        for (String autor : patent.getAuthors()) {
            autores.append(autor);
            autores.append(":");
        }

        dbPatent.setTitulo(patent.getTittle());
        dbPatent.setDescripcion(patent.getDescriptionText());
        dbPatent.setUrl(patent.getUrl());
        dbPatent.setFechaPublicacion(patent.getPublicationDate());
        dbPatent.setContenido(patent.getPatentString());
        dbPatent.setAutores(autores.toString().substring(0, autores.toString().length() - 1));

        return dbPatent;
    }
}
