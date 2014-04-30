package mx.com.icvt.persistence.impl.intsocial;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by lnx1337 on 21/04/14.
 */
public class CensosEducacionModel {

    public int cve_mun;
    public String anno;

    public List<CensosEducacion> getCensoEducacion() {
        List<CensosEducacion> competencias;
        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        Query query = manager.createQuery("SELECT c FROM CensosEducacion c WHERE c.cve_mun = :cve_mun AND c.anno = :anno");
        query.setParameter("cve_mun", this.getCve_mun());
        query.setParameter("anno", this.getAnno());
        competencias = query.getResultList();
        manager.close();
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
