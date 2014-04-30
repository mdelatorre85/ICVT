package mx.com.icvt.persistence.impl.intsocial;

import javax.persistence.*;

/**
 * Created by lnx1337 on 21/04/14.
 */

@Entity
@Table(name = "censos_educacion")
public class CensosEducacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int cve_mun;
    private int total;
    private int sin_escolaridad;
    private int basica;
    private int media_superior;
    private int superior;
    private int no_especificado;
    private int anno;

    public CensosEducacion() {
    }

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
