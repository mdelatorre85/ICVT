package mx.com.icvt.persistence.impl.intsocial;

import mx.com.icvt.persistence.impl.vocaciones.Municipio;

import javax.persistence.*;

@Entity
@Table(name = "censos_poblacion")
public class CensosPoblacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_municipio")
    private int total;

    @Column(name = "hombres")
    private int hombres;

    @Column(name = "mujeres")
    private int mujeres;

    @Column(name = "relacion_hm")
    private int relacionHombresMujeres;

    @Column(name = "superficie")
    private int superficie;

    @Column(name = "densidad")
    private int densidad;

    @Column(name = "anio")
    private int anio;

    @ManyToOne
    @JoinColumn(name = "id_municipio")
    private Municipio municipio;

    public CensosPoblacion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getRelacionHombresMujeres() {
        return relacionHombresMujeres;
    }

    public void setRelacionHombresMujeres(int relacionHombresMujeres) {
        this.relacionHombresMujeres = relacionHombresMujeres;
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

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
}
