package mx.com.icvt.persistence.impl.intsocial;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CensosEconomicos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String actividad_economica_id;
    private int cve_mun;
    private int unidades_economicas;
    private int activos_fijos;
    private int prod_bruta_total;
    private int personal_ocupado;
    private int valagreg_censalbruto;
    private int total_renumeraciones;
    private int anno;

    public CensosEconomicos() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActividad_economica_id() {
        return actividad_economica_id;
    }

    public void setActividad_economica_id(String actividad_economica_id) {
        this.actividad_economica_id = actividad_economica_id;
    }

    public int getCve_mun() {
        return cve_mun;
    }

    public void setCve_mun(int cve_mun) {
        this.cve_mun = cve_mun;
    }

    public int getUnidades_economicas() {
        return unidades_economicas;
    }

    public void setUnidades_economicas(int unidades_economicas) {
        this.unidades_economicas = unidades_economicas;
    }

    public int getActivos_fijos() {
        return activos_fijos;
    }

    public void setActivos_fijos(int activos_fijos) {
        this.activos_fijos = activos_fijos;
    }

    public int getProd_bruta_total() {
        return prod_bruta_total;
    }

    public void setProd_bruta_total(int prod_bruta_total) {
        this.prod_bruta_total = prod_bruta_total;
    }

    public int getPersonal_ocupado() {
        return personal_ocupado;
    }

    public void setPersonal_ocupado(int personal_ocupado) {
        this.personal_ocupado = personal_ocupado;
    }

    public int getValagreg_censalbruto() {
        return valagreg_censalbruto;
    }

    public void setValagreg_censalbruto(int valagreg_censalbruto) {
        this.valagreg_censalbruto = valagreg_censalbruto;
    }

    public int getTotal_renumeraciones() {
        return total_renumeraciones;
    }

    public void setTotal_renumeraciones(int total_renumeraciones) {
        this.total_renumeraciones = total_renumeraciones;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

}
