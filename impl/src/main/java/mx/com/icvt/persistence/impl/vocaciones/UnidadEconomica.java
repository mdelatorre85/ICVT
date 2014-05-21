package mx.com.icvt.persistence.impl.vocaciones;

import mx.com.icvt.model.EconomicUnit;
import mx.com.icvt.persistence.impl.questionnaries.Cuestionario;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "unidad_economica")
public class UnidadEconomica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_denue")
    private int numeroDenue;

    private String manzana;

    @Column(name = "nombre_establecimiento")
    private String nombreEstablecimiento;

    @Column(name = "nombre_propietario")
    private String nombrePropietario;

    private String direccion;

    private String calle;

    @Column(name = "numero_exterior")
    private String numeroExterior;

    @Column(name = "numero_interior")
    private String numeroInterior;

    private String colonia;

    @Column(name = "codigo_postal")
    private String codigoPostal;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "extension_telefono")
    private String extensionTelefono;

    @Column(name = "correo_electronico")
    private String correoElectronico;

    @Column(name = "url")
    private String url;

    @Column(name = "tipo_establecimiento")
    private String tipoEstablecimiento;

    @Column(name = "tipo_unidad_economica")
    private String tipoUnidadEconomica;

    private String estatus;

    private String alta;

    private Double longitud;

    private Double latitud;

    @ManyToOne
    @JoinColumn(name = "id_municipio")
    private Municipio municipio;

    @ManyToOne
    @JoinColumn(name = "id_localidad")
    private Localidad localidad;

    @ManyToOne
    @JoinColumn(name = "id_personal_ocupado")
    private PersonalOcupado personalOcupado;

    @ManyToOne
    @JoinColumn(name = "id_clase_actividad")
    private ClaseActividad claseActividad;

    @ManyToMany(mappedBy = "unidadEconomicas")
    private List<Cuestionario> cuestionarios;

    public UnidadEconomica() {
        cuestionarios = new ArrayList<Cuestionario>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UnidadEconomica(int cve_ent, int cve_num, int cve_loc) {
        cuestionarios = new ArrayList<Cuestionario>();
//        this.cve_ent = cve_ent;
//        this.cve_loc = cve_num;
//        this.cve_loc = cve_loc;
    }

    public UnidadEconomica(EconomicUnit economicUnit) {
        cuestionarios = new ArrayList<Cuestionario>();

//        this.d_llave = economicUnit.getD_llave();
//        this.cve_ent = economicUnit.getCve_ent();
//        this.cve_mun = economicUnit.getCve_mun();
//        this.cve_loc = economicUnit.getCve_loc();
//        this.manzana = economicUnit.getManzana();
//        this.nom_estab = economicUnit.getNom_estab();
//        this.nom_propie = economicUnit.getNom_propie();
//        this.direccion = economicUnit.getDireccion();
//        this.calle = economicUnit.getCalle();
//        this.numero_ext = economicUnit.getNumero_ext();
//        this.numero_int = economicUnit.getNumero_int();
//        this.colonia = economicUnit.getColonia();
//        this.cod_postal = economicUnit.getCod_postal();
//        this.telefono1 = economicUnit.getTelefono1();
//        this.ext_tel1 = economicUnit.getExt_tel1();
//        this.clase_act = economicUnit.getClase_act();
//        this.num_local = economicUnit.getNum_local();
//        this.correoelec = economicUnit.getCorreoelec();
//        this.www = economicUnit.getWww();
//        this.tipo_estab = economicUnit.getTipo_estab();
//        this.tipo_ue = economicUnit.getTipo_ue();
//        this.est_perocu = economicUnit.getEst_perocu();
        this.estatus = economicUnit.getEstatus();
        this.alta = economicUnit.getAlta();
        this.longitud = economicUnit.getLongitud();
        this.latitud = economicUnit.getLatitud();

    }

    public void setD_llave(int d_llave) {
//        this.d_llave = d_llave;
    }

    public int getNumeroDenue() {
        return numeroDenue;
    }

    public void setNumeroDenue(int numeroDenue) {
        this.numeroDenue = numeroDenue;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public String getManzana() {
        return manzana;
    }

    public void setManzana(String manzana) {
        this.manzana = manzana;
    }

    public String getNombreEstablecimiento() {
        return nombreEstablecimiento;
    }

    public void setNombreEstablecimiento(String nombreEstablecimiento) {
        this.nombreEstablecimiento = nombreEstablecimiento;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumeroExterior() {
        return numeroExterior;
    }

    public void setNumeroExterior(String numeroExterior) {
        this.numeroExterior = numeroExterior;
    }

    public String getNumeroInterior() {
        return numeroInterior;
    }

    public void setNumeroInterior(String numeroInterior) {
        this.numeroInterior = numeroInterior;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getExtensionTelefono() {
        return extensionTelefono;
    }

    public void setExtensionTelefono(String extensionTelefono) {
        this.extensionTelefono = extensionTelefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTipoEstablecimiento() {
        return tipoEstablecimiento;
    }

    public void setTipoEstablecimiento(String tipoEstablecimiento) {
        this.tipoEstablecimiento = tipoEstablecimiento;
    }

    public String getTipoUnidadEconomica() {
        return tipoUnidadEconomica;
    }

    public void setTipoUnidadEconomica(String tipoUnidadEconomica) {
        this.tipoUnidadEconomica = tipoUnidadEconomica;
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

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public PersonalOcupado getPersonalOcupado() {
        return personalOcupado;
    }

    public void setPersonalOcupado(PersonalOcupado personalOcupado) {
        this.personalOcupado = personalOcupado;
    }

    public ClaseActividad getClaseActividad() {
        return claseActividad;
    }

    public void setClaseActividad(ClaseActividad claseActividad) {
        this.claseActividad = claseActividad;
    }


    public List<Cuestionario> getCuestionarios() {
        return cuestionarios;
    }

    public void setCuestionarios(List<Cuestionario> cuestionarios) {
        this.cuestionarios = cuestionarios;
    }
}