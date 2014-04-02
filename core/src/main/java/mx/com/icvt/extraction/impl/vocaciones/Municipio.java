package mx.com.icvt.extraction.impl.vocaciones;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

/**
 * Created with IntelliJ IDEA.
 * User: Cesar
 * Date: 17/03/14
 * Time: 18:32
 */
@PersistenceCapable
public class Municipio {
    @PrimaryKey
    private int cve_mun;
    private String municipio;

    public int getCve_mun() {
        return cve_mun;
    }

    public void setCve_mun(int cve_mun) {
        this.cve_mun = cve_mun;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
}
