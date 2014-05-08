package mx.com.icvt.persistence.impl.news;

import javax.persistence.*;

@Entity
@Table(name = "configuracion_extraccion_noticias")
public class ConfiguracionExtraccionNoticias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "termino_busqueda")
    private String terminoBusqueda;
    private String fuente;

    public ConfiguracionExtraccionNoticias() {
    }

    public ConfiguracionExtraccionNoticias(String terminoBusqueda, String fuente) {
        this.terminoBusqueda = terminoBusqueda;
        this.fuente = fuente;
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
}
