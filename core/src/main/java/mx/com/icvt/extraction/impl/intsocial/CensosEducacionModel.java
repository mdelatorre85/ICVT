package mx.com.icvt.extraction.impl.intsocial;

import javax.jdo.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lnx1337 on 21/04/14.
 */
public class CensosEducacionModel {

    public int cve_mun;
    public String anno;

    public List<CensosEducacion> getCensoEducacion() {

        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("SITE");
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();

        List<CensosEducacion> competencias;
        competencias = Arrays.asList();

        try
        {
            tx.begin();
            Query q = pm.newQuery("SELECT FROM " + CensosEducacion.class.getName()+" where cve_mun=="+ this.getCve_mun()+" && anno=="+this.getAnno());
            competencias = (List<CensosEducacion>)q.execute();
            tx.commit();
        }
        catch (Exception e)
        {
            System.out.println("Exception performing queries : " + e.getMessage());
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }

        return competencias;
    }


    public String getAnno() {
        return anno;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }

    public int getCve_mun() {
        return cve_mun;
    }

    public void setCve_mun(int cve_mun) {
        this.cve_mun = cve_mun;
    }

}
