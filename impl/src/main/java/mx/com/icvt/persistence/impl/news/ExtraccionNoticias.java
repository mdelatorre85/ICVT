package mx.com.icvt.persistence.impl.news;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "Extraccion_noticias")
public class ExtraccionNoticias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;

    @ManyToOne
    @JoinColumn(name = "id_configuracion")
    private ConfiguracionExtraccionNoticias configuracion;

    @ManyToMany
    @JoinTable(name = "extraccion_noticias_noticias",
            joinColumns = {@JoinColumn(name = "extraccion_id")},
            inverseJoinColumns = {@JoinColumn(name = "noticia_id")})
    private List<Noticia> noticias;

    public ExtraccionNoticias() {
    }

    public ExtraccionNoticias(Date fechaInicio, Date fechaFin, ConfiguracionExtraccionNoticias configuracion) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.configuracion = configuracion;
        noticias = new LinkedList<Noticia>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public ConfiguracionExtraccionNoticias getConfiguracion() {
        return configuracion;
    }

    public void setConfiguracion(ConfiguracionExtraccionNoticias configuracion) {
        this.configuracion = configuracion;
    }

    public List<Noticia> getNoticias() {
        return noticias;
    }

    public void setNoticias(List<Noticia> noticias) {
        this.noticias = noticias;
    }
}
