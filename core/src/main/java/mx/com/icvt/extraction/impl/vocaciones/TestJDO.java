package mx.com.icvt.extraction.impl.vocaciones;

import javax.jdo.*;
import java.util.Iterator;

public class TestJDO {
    public static void main(String args[]) {
       PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("SITE");
        PersistenceManager pm = pmf.getPersistenceManager();

        try {
            System.out.println("Retrieving Extent");
            Extent<Municipio> e = pm.getExtent(Municipio.class, true);
            int i = 0;
            Iterator<Municipio> iter = e.iterator();
            while (iter.hasNext() && i++ < 10 ) {
                Municipio obj = iter.next();
                System.out.println(">  " + obj.getMunicipio());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception thrown during retrieval of Extent : " + e.getMessage());
        } finally {
            pm.close();
        }
    }

}
