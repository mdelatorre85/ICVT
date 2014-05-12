package mx.com.icvt.persistence.impl.tweets;

import mx.com.icvt.persistence.impl.vocaciones.ClaseActividad;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "configuracion_extraccion_tweets")
public class ConfiguracionExtraccionTweets {
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
    private List<ExtraccionTweets> extracciones;

    public ConfiguracionExtraccionTweets() {
    }

    public ConfiguracionExtraccionTweets(String terminoBusqueda, String fuente) {
        this.terminoBusqueda = terminoBusqueda;
        this.fuente = fuente;
        extracciones = new LinkedList<ExtraccionTweets>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTerminoBusqueda() {
        return terminoBusqueda;
    }

    public void setTerminoBusqueda(String terminoBusqueda) {
        this.terminoBusqueda = terminoBusqueda;
    }

    public String getFuente() {
        return fuente;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
    }

    public ClaseActividad getClaseActividad() {
        return claseActividad;
    }

    public void setClaseActividad(ClaseActividad claseActividad) {
        this.claseActividad = claseActividad;
    }

    public List<ExtraccionTweets> getExtracciones() {
        return extracciones;
    }

    public void setExtracciones(List<ExtraccionTweets> extracciones) {
        this.extracciones = extracciones;
    }
}
