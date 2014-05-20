package mx.com.icvt.persistence.impl.vocaciones;

import mx.com.icvt.model.EconomicUnit;
import mx.com.icvt.model.cuestionarios.Questionary;
import mx.com.icvt.persistence.impl.news.Noticia;
import mx.com.icvt.persistence.impl.questionnaries.Cuestionario;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "unidad_economica")
public class UnidadEconomica {
    @Id
    private int d_llave;
    private int cve_ent;
    private int cve_mun;
    private int cve_loc;
    private String manzana;
    private String nom_estab;
    private String nom_propie;
    private String direccion;
    private String calle;
    private String numero_ext;
    private String numero_int;
    private String colonia;
    private String cod_postal;
    private String telefono1;
    private String ext_tel1;
    private String clase_act;
    private String num_local;
    private String correoelec;
    private String www;
    private String tipo_estab;
    private String tipo_ue;
    private long est_perocu;
    private String estatus;
    private String alta;
    private Double longitud;
    private Double latitud;

   @ManyToMany(mappedBy = "unidadEconomicas")
    private List<Cuestionario> cuestionarios;

    public UnidadEconomica() {
        cuestionarios = new ArrayList<Cuestionario>();
    }

    public UnidadEconomica(int cve_ent, int cve_num, int cve_loc) {
        cuestionarios = new ArrayList<Cuestionario>();
        this.cve_ent = cve_ent;
        this.cve_loc = cve_num;
        this.cve_loc = cve_loc;
    }

    public UnidadEconomica (EconomicUnit economicUnit){
        cuestionarios = new ArrayList<Cuestionario>();

        this.d_llave = economicUnit.getD_llave();
        this.cve_ent = economicUnit.getCve_ent();
        this.cve_mun = economicUnit.getCve_mun();
        this.cve_loc = economicUnit.getCve_loc();
        this.manzana = economicUnit.getManzana();
        this.nom_estab = economicUnit.getNom_estab();
        this.nom_propie = economicUnit.getNom_propie();
        this.direccion = economicUnit.getDireccion();
        this.calle = economicUnit.getCalle();
        this.numero_ext = economicUnit.getNumero_ext();
        this.numero_int = economicUnit.getNumero_int();
        this.colonia = economicUnit.getColonia();
        this.cod_postal = economicUnit.getCod_postal();
        this.telefono1 = economicUnit.getTelefono1();
        this.ext_tel1 = economicUnit.getExt_tel1();
        this.clase_act = economicUnit.getClase_act();
        this.num_local = economicUnit.getNum_local();
        this.correoelec = economicUnit.getCorreoelec();
        this.www = economicUnit.getWww();
        this.tipo_estab = economicUnit.getTipo_estab();
        this.tipo_ue = economicUnit.getTipo_ue();
        this.est_perocu = economicUnit.getEst_perocu();
        this.estatus = economicUnit.getEstatus();
        this.alta = economicUnit.getAlta();
        this.longitud = economicUnit.getLongitud();
        this.latitud = economicUnit.getLatitud();

    }

    public void setD_llave(int d_llave) {
        this.d_llave = d_llave;
    }

    public int getCve_ent() {
        return cve_ent;
    }

    public void setCve_ent(int cve_ent) {
        this.cve_ent = cve_ent;
    }

    public int getCve_mun() {
        return cve_mun;
    }

    public void setCve_mun(int cve_mun) {
        this.cve_mun = cve_mun;
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


    public List<Cuestionario> getCuestionarios() {
        return cuestionarios;
    }

    public void setCuestionarios(List<Cuestionario> cuestionarios) {
        this.cuestionarios = cuestionarios;
    }
}