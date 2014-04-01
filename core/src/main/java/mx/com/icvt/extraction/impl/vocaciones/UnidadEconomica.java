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
    public  int cve_num;

    @Persistent
    public int cve_loc;

    @Persistent
    public String nic;

    @Persistent
    public String nop;

    @Persistent
    public String ageb;

    @Persistent
    public String manzana;

    @Persistent
    public String nom_estab;

    @Persistent
    public String nom_propie;

    @Persistent
    public String tipo_calle;

    @Persistent
    public String calle;

    @Persistent
    public String tipo_vial1;

    @Persistent
    public String calle_1;

    @Persistent
    public String tipo_vial2;

    @Persistent
    public String calle2;

    @Persistent
    public String tipo_vial3;

    @Persistent
    public String calle3;

    @Persistent
    public String numero_ext;

    @Persistent
    public String edificio;

    @Persistent
    public String numero_int;

    @Persistent
    public String tipo_asent;

    @Persistent
    public String colonia;

    @Persistent
    public String cod_postal;

    @Persistent
    public String telefono1;

    @Persistent
    public String ext_tel2;

    @Persistent
    public String fax;

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

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getNop() {
        return nop;
    }

    public void setNop(String nop) {
        this.nop = nop;
    }

    public String getAgeb() {
        return ageb;
    }

    public void setAgeb(String ageb) {
        this.ageb = ageb;
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

    public String getTipo_calle() {
        return tipo_calle;
    }

    public void setTipo_calle(String tipo_calle) {
        this.tipo_calle = tipo_calle;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getTipo_vial1() {
        return tipo_vial1;
    }

    public void setTipo_vial1(String tipo_vial1) {
        this.tipo_vial1 = tipo_vial1;
    }

    public String getCalle_1() {
        return calle_1;
    }

    public void setCalle_1(String calle_1) {
        this.calle_1 = calle_1;
    }

    public String getTipo_vial2() {
        return tipo_vial2;
    }

    public void setTipo_vial2(String tipo_vial2) {
        this.tipo_vial2 = tipo_vial2;
    }

    public String getCalle2() {
        return calle2;
    }

    public void setCalle2(String calle2) {
        this.calle2 = calle2;
    }

    public String getTipo_vial3() {
        return tipo_vial3;
    }

    public void setTipo_vial3(String tipo_vial3) {
        this.tipo_vial3 = tipo_vial3;
    }

    public String getCalle3() {
        return calle3;
    }

    public void setCalle3(String calle3) {
        this.calle3 = calle3;
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

    public String getTipo_asent() {
        return tipo_asent;
    }

    public void setTipo_asent(String tipo_asent) {
        this.tipo_asent = tipo_asent;
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

    public String getExt_tel2() {
        return ext_tel2;
    }

    public void setExt_tel2(String ext_tel2) {
        this.ext_tel2 = ext_tel2;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
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

    public UnidadEconomica(){
        super();
    }


}