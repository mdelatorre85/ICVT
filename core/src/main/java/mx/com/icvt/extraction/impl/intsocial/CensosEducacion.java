package mx.com.icvt.extraction.impl.intsocial;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * Created by lnx1337 on 21/04/14.
 */

@PersistenceCapable(table="censos_educacion")
public class CensosEducacion {

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    public int id;

    @Persistent
    public int cve_mun;

    @Persistent
    public int total;

    @Persistent
    public int sin_escolaridad;

    @Persistent
    public int basica;

    @Persistent
    public int media_superior;

    @Persistent
    public  int superior;

    @Persistent
    public int no_especificado;

    @Persistent
    public int anno;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCve_mun() {
        return cve_mun;
    }

    public void setCve_mun(int cve_mun) {
        this.cve_mun = cve_mun;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSin_escolaridad() {
        return sin_escolaridad;
    }

    public void setSin_escolaridad(int sin_escolaridad) {
        this.sin_escolaridad = sin_escolaridad;
    }

    public int getBasica() {
        return basica;
    }

    public void setBasica(int basica) {
        this.basica = basica;
    }

    public int getMedia_superior() {
        return media_superior;
    }

    public void setMedia_superior(int media_superior) {
        this.media_superior = media_superior;
    }

    public int getSuperior() {
        return superior;
    }

    public void setSuperior(int superior) {
        this.superior = superior;
    }

    public int getNo_especificado() {
        return no_especificado;
    }

    public void setNo_especificado(int no_especificado) {
        this.no_especificado = no_especificado;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }
}
