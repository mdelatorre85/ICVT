package mx.com.icvt.persistence.impl.intsocial;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();

        List<CensosEconomicos> competencias;

        Query query = manager.createQuery("SELECT c FROM CensosEconomicos c where c.cve_mun = :cve_mun AND c.actividad_economica_id LIKE :actividadEconomica AND c.anno = :anio");
        query.setParameter("cve_mun", this.getCve_mun());
        query.setParameter("actividad_economica_id", this.getCve_actividad_economica() + "%");
        query.setParameter("anio", this.getAnno());
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

    public String getCve_actividad_economica() {
        return cve_actividad_economica;
    }

    public void setCve_actividad_economica(String cve_actividad_economica) {
        this.cve_actividad_economica = cve_actividad_economica;
    }
}
