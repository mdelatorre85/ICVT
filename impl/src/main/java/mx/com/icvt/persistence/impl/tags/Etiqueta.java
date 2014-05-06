package mx.com.icvt.persistence.impl.tags;

import mx.com.icvt.persistence.impl.news.Noticia;
import mx.com.icvt.persistence.impl.patents.DBPatent;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Etiquetas")
public class Etiqueta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String valor;
    @ManyToMany(mappedBy = "etiquetas")
    private List<Noticia> noticias;
    @ManyToMany(mappedBy = "etiquetas")
    private List<DBPatent> patentes;

    public Etiqueta() {
        noticias = new ArrayList<Noticia>();
        patentes = new ArrayList<DBPatent>();
    }

    public Etiqueta(String valor){
        noticias = new ArrayList<Noticia>();
        patentes = new ArrayList<DBPatent>();
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

    public List<Noticia> getNoticias() {
        return noticias;
    }

    public void setNoticias(List<Noticia> noticias) {
        this.noticias = noticias;
    }

    public List<DBPatent> getPatentes() {
        return patentes;
    }

    public void setPatentes(List<DBPatent> patentes) {
        this.patentes = patentes;
    }
}
