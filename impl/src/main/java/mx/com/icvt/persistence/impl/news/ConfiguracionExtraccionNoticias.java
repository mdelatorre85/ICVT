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

}
