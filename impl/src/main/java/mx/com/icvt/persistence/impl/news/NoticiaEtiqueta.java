package mx.com.icvt.persistence.impl.news;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class NoticiaEtiqueta {
    @Persistent(primaryKey = "true", valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;
    private Long idNoticia;
    private Long idEtiqueta;

    public NoticiaEtiqueta() {
    }

    public NoticiaEtiqueta(Long idNoticia, Long idEtiqueta) {
        this.idNoticia = idNoticia;
        this.idEtiqueta = idEtiqueta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(Long idNoticia) {
        this.idNoticia = idNoticia;
    }

    public Long getIdEtiqueta() {
        return idEtiqueta;
    }

    public void setIdEtiqueta(Long idEtiqueta) {
        this.idEtiqueta = idEtiqueta;
    }
}
