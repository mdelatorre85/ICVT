package mx.com.icvt.persistence.impl.news;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Extraccion_noticias")
public class ExtraccionNoticias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fecha_inico")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;

    public ExtraccionNoticias() {
    }

    public ExtraccionNoticias(Date fechaInicio, Date fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
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
}
