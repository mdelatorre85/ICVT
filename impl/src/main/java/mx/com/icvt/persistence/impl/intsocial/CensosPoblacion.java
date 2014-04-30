package mx.com.icvt.persistence.impl.intsocial;

import javax.persistence.*;

@Entity
@Table(name = "censos_poblacion")
public class CensosPoblacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int cve_mun;
    private int total;
    private int hombres;
    private int mujeres;
    private int relacion_hm;
    private int superficie;
    private int densidad;
    private int anno;

    public CensosPoblacion() {
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

    public int getHombres() {
        return hombres;
    }

    public void setHombres(int hombres) {
        this.hombres = hombres;
    }

    public int getMujeres() {
        return mujeres;
    }

    public void setMujeres(int mujeres) {
        this.mujeres = mujeres;
    }

    public int getRelacion_hm() {
        return relacion_hm;
    }

    public void setRelacion_hm(int relacion_hm) {
        this.relacion_hm = relacion_hm;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public int getDensidad() {
        return densidad;
    }

    public void setDensidad(int densidad) {
        this.densidad = densidad;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }
}
