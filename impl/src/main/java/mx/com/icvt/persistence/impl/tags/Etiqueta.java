package mx.com.icvt.persistence.impl.tags;

import mx.com.icvt.persistence.impl.news.Noticia;
import mx.com.icvt.persistence.impl.patents.DBPatent;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Etiqueta")
public class Etiqueta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String valor;
    @ManyToMany
    private List<Noticia> noticias;
    @ManyToMany
    private List<DBPatent> patentes;

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
