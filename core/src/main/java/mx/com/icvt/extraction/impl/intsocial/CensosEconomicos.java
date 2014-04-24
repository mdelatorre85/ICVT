package mx.com.icvt.extraction.impl.intsocial;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(table="censos_economicos")
public class CensosEconomicos {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	public int id;

    @Persistent
	public String actividad_economica_id;
	
	@Persistent
	public int cve_mun;
	
	@Persistent
	public int unidades_economicas;
	
	@Persistent
	public int activos_fijos;
	
	@Persistent
	public int prod_bruta_total;
	
	@Persistent
	public int personal_ocupado;
	
	@Persistent
	public int valagreg_censalbruto;
	
	@Persistent
	public int total_renumeraciones;
	
	@Persistent
	public int anno;

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
