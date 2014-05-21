package mx.com.icvt.persistence.impl.vocaciones;

import mx.com.icvt.persistence.impl.news.ConfiguracionExtraccionNoticias;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "clase_actividades")
public class ClaseActividad {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "claseActividad")
    private List<ConfiguracionExtraccionNoticias> configuracionesExtraccionNoticias;

    @OneToMany(mappedBy = "claseActividad")
    private List<UnidadEconomica> unidadEconomicas;

    public ClaseActividad() {
        configuracionesExtraccionNoticias = new LinkedList<ConfiguracionExtraccionNoticias>();
        unidadEconomicas = new LinkedList<UnidadEconomica>();
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

    public List<ConfiguracionExtraccionNoticias> getConfiguracionesExtraccionNoticias() {
        return configuracionesExtraccionNoticias;
    }

    public void setConfiguracionesExtraccionNoticias(List<ConfiguracionExtraccionNoticias> configuracionesExtraccionNoticias) {
        this.configuracionesExtraccionNoticias = configuracionesExtraccionNoticias;
    }

    public List<UnidadEconomica> getUnidadEconomicas() {
        return unidadEconomicas;
    }

    public void setUnidadEconomicas(List<UnidadEconomica> unidadEconomicas) {
        this.unidadEconomicas = unidadEconomicas;
    }
}