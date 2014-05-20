package mx.com.icvt.persistence.impl.vocaciones;

import mx.com.icvt.persistence.impl.intsocial.CensosEconomicos;
import mx.com.icvt.persistence.impl.intsocial.CensosEducacion;
import mx.com.icvt.persistence.impl.intsocial.CensosPoblacion;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Cesar
 * Date: 17/03/14
 * Time: 18:32
 */
@Entity
@Table(name = "municipio")
public class Municipio {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_entidad")
    private EntidadFederativa entidad;

    @OneToMany(mappedBy = "municipio")
    private List<UnidadEconomica> unidadesEconomicas;

    @OneToMany(mappedBy = "municipio")
    private List<CensosEducacion> censosEducacion;

    @OneToMany(mappedBy = "municipio")
    private List<CensosPoblacion> censosPoblacion;

    @OneToMany(mappedBy = "municipio")
    private List<CensosEconomicos> censosEconomicos;

    public Municipio() {
        this.unidadesEconomicas = new LinkedList<UnidadEconomica>();
        this.censosEducacion = new LinkedList<CensosEducacion>();
        this.censosPoblacion = new LinkedList<CensosPoblacion>();
        this.censosEconomicos = new LinkedList<CensosEconomicos>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EntidadFederativa getEntidad() {
        return entidad;
    }

    public void setEntidad(EntidadFederativa entidad) {
        this.entidad = entidad;
    }

    public List<UnidadEconomica> getUnidadesEconomicas() {
        return unidadesEconomicas;
    }

    public void setUnidadesEconomicas(List<UnidadEconomica> unidadesEconomicas) {
        this.unidadesEconomicas = unidadesEconomicas;
    }

    public List<CensosEducacion> getCensosEducacion() {
        return censosEducacion;
    }

    public void setCensosEducacion(List<CensosEducacion> censosEducacion) {
        this.censosEducacion = censosEducacion;
    }

    public List<CensosPoblacion> getCensosPoblacion() {
        return censosPoblacion;
    }

    public void setCensosPoblacion(List<CensosPoblacion> censosPoblacion) {
        this.censosPoblacion = censosPoblacion;
    }

    public List<CensosEconomicos> getCensosEconomicos() {
        return censosEconomicos;
    }

    public void setCensosEconomicos(List<CensosEconomicos> censosEconomicos) {
        this.censosEconomicos = censosEconomicos;
    }
}
