package mx.com.icvt.extraction.impl.vocaciones;

import javax.jdo.PersistenceManagerFactory;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.JDOHelper;
import javax.jdo.Transaction;
import java.util.List;
import java.util.Iterator;
import javax.jdo.Extent;
import java.util.Collection;
import mx.com.icvt.extraction.impl.vocaciones.PMF;


/**
 * Created by lnx1337 on 16/03/14.
 */
public class TestJDO {


    public static void main(String[] args) {

        System.out.println("JDO Testing Hello");

       /*

        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("SITE");
        PersistenceManager pm;
        pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();

        */
        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("SITE");

        PersistenceManager pm;

        pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        tx = pm.currentTransaction();

        try
        {
            tx.begin();
            System.out.println("Retrieving Extent");
            Extent e = pm.getExtent(UnidadEconomica.class, true);
            Iterator iter = e.iterator();
            while (iter.hasNext())
            {
                Object obj = iter.next();
                System.out.println(">  " + obj);
            }
            tx.commit();
        }
        catch (Exception e)
        {
            System.out.println("Exception thrown during retrieval of Extent : " + e.getMessage());
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
        System.out.println("");

        /*
        PersistenceManager pm = PMF.get().getPersistenceManager();
       //PersistenceManager pm = pmf.getPersistenceManager();
        Query q = pm.newQuery(UnidadEconomica.class);
        System.out.println(q);
        List<UnidadEconomica> results = (List<UnidadEconomica>) q.execute();
        System.out.println(results);

        */


    }

}
