package mx.com.icvt.extraction.impl.vocaciones;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


/**
 * Created by lnx1337 on 16/03/14.
 */

@PersistenceCapable(table = "unidad_economica")
public class UnidadEconomica {

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    public int d_llave;

    @Persistent
    public int cve_ent;

    @Persistent
    public int cve_num;

    @Persistent
    public int cve_loc;

    @Persistent
    public String manzana;

    @Persistent
    public String nom_estab;

    @Persistent
    public String nom_propie;

    public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getExt_tel1() {
		return ext_tel1;
	}

	public void setExt_tel1(String ext_tel1) {
		this.ext_tel1 = ext_tel1;
	}

	public int getD_llave() {
		return d_llave;
	}

	public Double getLongitud() {
		return longitud;
	}

	public Double getLatitud() {
		return latitud;
	}

	@Persistent
    public String direccion;

    @Persistent
    public String calle;
    
    @Persistent
    public String numero_ext;

    @Persistent
    public String edificio;

    @Persistent
    public String numero_int;

    @Persistent
    public String colonia;

    @Persistent
    public String cod_postal;

    @Persistent
    public String telefono1;

    @Persistent
    public String ext_tel1;

    @Persistent
    public String clase_act;

    @Persistent
    public String centro_com;

    @Persistent
    public String num_local;

    @Persistent
    public String correoelec;

    @Persistent
    public String www;

    @Persistent
    public String correoelec2;

    @Persistent
    public String tipo_estab;

    @Persistent
    public String tipo_ue;

    @Persistent
    public long est_perocu;

    @Persistent
    public String estatus;

    @Persistent
    public String alta;

    @Persistent
    public Double longitud;

    @Persistent
    public Double latitud;

    public void setD_llave(int d_llave) {
        this.d_llave = d_llave;
    }

    public int getCve_ent() {
        return cve_ent;
    }

    public void setCve_ent(int cve_ent) {
        this.cve_ent = cve_ent;
    }

    public int getCve_num() {
        return cve_num;
    }

    public void setCve_num(int cve_num) {
        this.cve_num = cve_num;
    }

    public int getCve_loc() {
        return cve_loc;
    }

    public void setCve_loc(int cve_loc) {
        this.cve_loc = cve_loc;
    }

    public String getManzana() {
        return manzana;
    }

    public void setManzana(String manzana) {
        this.manzana = manzana;
    }

    public String getNom_estab() {
        return nom_estab;
    }

    public void setNom_estab(String nom_estab) {
        this.nom_estab = nom_estab;
    }

    public String getNom_propie() {
        return nom_propie;
    }

    public void setNom_propie(String nom_propie) {
        this.nom_propie = nom_propie;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero_ext() {
        return numero_ext;
    }

    public void setNumero_ext(String numero_ext) {
        this.numero_ext = numero_ext;
    }

    public String getEdificio() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    public String getNumero_int() {
        return numero_int;
    }

    public void setNumero_int(String numero_int) {
        this.numero_int = numero_int;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCod_postal() {
        return cod_postal;
    }

    public void setCod_postal(String cod_postal) {
        this.cod_postal = cod_postal;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getClase_act() {
        return clase_act;
    }

    public void setClase_act(String clase_act) {
        this.clase_act = clase_act;
    }

    public String getCentro_com() {
        return centro_com;
    }

    public void setCentro_com(String centro_com) {
        this.centro_com = centro_com;
    }

    public String getNum_local() {
        return num_local;
    }

    public void setNum_local(String num_local) {
        this.num_local = num_local;
    }

    public String getCorreoelec() {
        return correoelec;
    }

    public void setCorreoelec(String correoelec) {
        this.correoelec = correoelec;
    }

    public String getWww() {
        return www;
    }

    public void setWww(String www) {
        this.www = www;
    }

    public String getCorreoelec2() {
        return correoelec2;
    }

    public void setCorreoelec2(String correoelec2) {
        this.correoelec2 = correoelec2;
    }

    public String getTipo_estab() {
        return tipo_estab;
    }

    public void setTipo_estab(String tipo_estab) {
        this.tipo_estab = tipo_estab;
    }

    public String getTipo_ue() {
        return tipo_ue;
    }

    public void setTipo_ue(String tipo_ue) {
        this.tipo_ue = tipo_ue;
    }

    public long getEst_perocu() {
        return est_perocu;
    }

    public void setEst_perocu(long est_perocu) {
        this.est_perocu = est_perocu;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getAlta() {
        return alta;
    }

    public void setAlta(String alta) {
        this.alta = alta;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public UnidadEconomica(int cve_ent, int cve_num, int cve_loc) {
        this.cve_ent = cve_ent;
        this.cve_loc = cve_num;
        this.cve_loc = cve_loc;
    }

    public UnidadEconomica() {
        super();
    }


}