package mx.com.icvt.persistence.impl.intsocial;

import mx.com.icvt.persistence.impl.vocaciones.Municipio;

import javax.persistence.*;

@Entity
@Table(name = "censos_economicos")
public class CensosEconomicos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "unidades_economicas")
    private int unidadesEconomicas;

    @Column(name = "activos_fijos")
    private int activosFijos;

    @Column(name = "prod_bruta_total")
    private int produccionBrutaTotal;

    @Column(name = "personal_ocupado")
    private int personalOcupado;

    @Column(name = "valagreg_censalbruto")
    private int valorAgregadoCensalBruto;

    @Column(name = "total_renumeraciones")
    private int totalRemuneraciones;

    @Column(name = "anio")
    private int anio;

    @ManyToOne
    @JoinColumn(name = "id_actividad_economica")
    private ActividadEconomica actividadEconomica;

    @ManyToOne
    @JoinColumn(name = "id_municipio")
    private Municipio municipio;

    public CensosEconomicos() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUnidadesEconomicas() {
        return unidadesEconomicas;
    }

    public void setUnidadesEconomicas(int unidadesEconomicas) {
        this.unidadesEconomicas = unidadesEconomicas;
    }

    public int getActivosFijos() {
        return activosFijos;
    }

    public void setActivosFijos(int activosFijos) {
        this.activosFijos = activosFijos;
    }

    public int getProduccionBrutaTotal() {
        return produccionBrutaTotal;
    }

    public void setProduccionBrutaTotal(int produccionBrutaTotal) {
        this.produccionBrutaTotal = produccionBrutaTotal;
    }

    public int getPersonalOcupado() {
        return personalOcupado;
    }

    public void setPersonalOcupado(int personalOcupado) {
        this.personalOcupado = personalOcupado;
    }

    public int getValorAgregadoCensalBruto() {
        return valorAgregadoCensalBruto;
    }

    public void setValorAgregadoCensalBruto(int valorAgregadoCensalBruto) {
        this.valorAgregadoCensalBruto = valorAgregadoCensalBruto;
    }

    public int getTotalRemuneraciones() {
        return totalRemuneraciones;
    }

    public void setTotalRemuneraciones(int totalRemuneraciones) {
        this.totalRemuneraciones = totalRemuneraciones;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public ActividadEconomica getActividadEconomica() {
        return actividadEconomica;
    }

    public void setActividadEconomica(ActividadEconomica actividadEconomica) {
        this.actividadEconomica = actividadEconomica;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
}
