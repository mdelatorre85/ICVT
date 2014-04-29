package mx.com.icvt.persistence.impl.tags;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class Etiqueta {
    @Persistent(primaryKey = "true", valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;
    private String valor;

    public Etiqueta() {
    }

    public Etiqueta(String valor){
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
