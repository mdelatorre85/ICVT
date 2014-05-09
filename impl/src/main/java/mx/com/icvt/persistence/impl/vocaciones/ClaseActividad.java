package mx.com.icvt.persistence.impl.vocaciones;

import mx.com.icvt.persistence.impl.news.ConfiguracionExtraccionNoticias;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clase_actividades")
public class ClaseActividad {
    @Id
    @Column(name = "clase_act")
    private Long id;
    @Column(name = "desc_act")
    private String descripcion;
    @OneToMany(mappedBy = "claseActividad")
    private List<ConfiguracionExtraccionNoticias> configuracionesExtraccionNoticias;

    public ClaseActividad() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
