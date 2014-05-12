package mx.com.icvt.persistence.impl.patents;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "extraccion_patentes")
public class ExtraccionPatentes {
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
    private ConfiguracionExtraccionPatentes configuracion;

    @ManyToMany
    @JoinTable(name = "extraccion_patentes_patentes",
            joinColumns = {
                    @JoinColumn(name = "extraccion_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "patente_id")
            }
    )
    private List<DBPatent> patentes;

    public ExtraccionPatentes() {
    }

    public ExtraccionPatentes(Date fechaInicio, Date fechaFin, ConfiguracionExtraccionPatentes configuracion) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.configuracion = configuracion;
        this.patentes = new LinkedList<DBPatent>();
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

    public ConfiguracionExtraccionPatentes getConfiguracion() {
        return configuracion;
    }

    public void setConfiguracion(ConfiguracionExtraccionPatentes configuracion) {
        this.configuracion = configuracion;
    }

    public List<DBPatent> getPatentes() {
        return patentes;
    }

    public void setPatentes(List<DBPatent> patentes) {
        this.patentes = patentes;
    }
}
