package mx.com.icvt.extraction.impl.intsocial;

import javax.jdo.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lnx1337 on 16/04/14.
 */
public class CensosEconomicosModel {

    public int cve_mun;

    public String anno;

    public String cve_actividad_economica;

    public List<CensosEconomicos> getCensoEconomico() {

        System.out.println(this.getCve_mun());
        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("SITE");
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();

        List<CensosEconomicos> competencias;
        competencias = Arrays.asList();

        try
        {
            tx.begin();
            Query q = pm.newQuery("SELECT FROM " + CensosEconomicos.class.getName()+" where cve_mun=="+ this.getCve_mun()+" && actividad_economica_id.startsWith(\""+this.getCve_actividad_economica()+"\") && anno=="+this.getAnno());
            competencias = (List<CensosEconomicos>)q.execute();
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

    public String getCve_actividad_economica() {
        return cve_actividad_economica;
    }

    public void setCve_actividad_economica(String cve_actividad_economica) {
        this.cve_actividad_economica = cve_actividad_economica;
    }
}
