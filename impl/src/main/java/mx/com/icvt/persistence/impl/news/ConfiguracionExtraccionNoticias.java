package mx.com.icvt.persistence.impl.news;

import mx.com.icvt.persistence.impl.vocaciones.ClaseActividad;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "configuracion_extraccion_noticias")
public class ConfiguracionExtraccionNoticias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "termino_busqueda")
    private String terminoBusqueda;
    private String fuente;
    @ManyToOne
    @JoinColumn(name = "id_clase_actividad")
    private ClaseActividad claseActividad;
    @OneToMany(mappedBy = "configuracion")
    private List<ExtraccionNoticias> extraccionesNoticias;

    public ConfiguracionExtraccionNoticias() {
    }

    public ConfiguracionExtraccionNoticias(String terminoBusqueda, String fuente) {
        this.terminoBusqueda = terminoBusqueda;
        this.fuente = fuente;
        this.extraccionesNoticias = new LinkedList<ExtraccionNoticias>();
    }

    public String getFuente() {
        return fuente;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
    }

    public String getTerminoBusqueda() {
        return terminoBusqueda;
    }

    public void setTerminoBusqueda(String terminoBusqueda) {
        this.terminoBusqueda = terminoBusqueda;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClaseActividad getClaseActividad() {
        return claseActividad;
    }

    public void setClaseActividad(ClaseActividad claseActividad) {
        this.claseActividad = claseActividad;
    }

    public List<ExtraccionNoticias> getExtraccionesNoticias() {
        return extraccionesNoticias;
    }

    public void setExtraccionesNoticias(List<ExtraccionNoticias> extraccionesNoticias) {
        this.extraccionesNoticias = extraccionesNoticias;
    }
}
