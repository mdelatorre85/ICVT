package mx.com.icvt.persistence.impl.intsocial;

import mx.com.icvt.persistence.impl.vocaciones.Municipio;

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

    @Column(name = "total")
    private int total;

    @Column(name = "sin_escolaridad")
    private int sinEscolaridad;

    @Column(name = "basica")
    private int basica;

    @Column(name = "media_superior")
    private int mediaSuperior;

    @Column(name = "superior")
    private int superior;

    @Column(name = "no_especificado")
    private int noEspecificado;

    @Column(name = "anio")
    private int anio;

    @ManyToOne
    @JoinColumn(name = "id_municipio")
    private Municipio municipio;

    public CensosEducacion() {
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

    public int getSinEscolaridad() {
        return sinEscolaridad;
    }

    public void setSinEscolaridad(int sinEscolaridad) {
        this.sinEscolaridad = sinEscolaridad;
    }

    public int getBasica() {
        return basica;
    }

    public void setBasica(int basica) {
        this.basica = basica;
    }

    public int getMediaSuperior() {
        return mediaSuperior;
    }

    public void setMediaSuperior(int mediaSuperior) {
        this.mediaSuperior = mediaSuperior;
    }

    public int getSuperior() {
        return superior;
    }

    public void setSuperior(int superior) {
        this.superior = superior;
    }

    public int getNoEspecificado() {
        return noEspecificado;
    }

    public void setNoEspecificado(int noEspecificado) {
        this.noEspecificado = noEspecificado;
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
