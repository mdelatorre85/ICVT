package mx.com.icvt.persistence.impl.tags;

import mx.com.icvt.persistence.impl.news.Noticia;
import mx.com.icvt.persistence.impl.patents.DBPatent;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "etiquetas")
public class Etiqueta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String valor;
    private String color;
    @ManyToMany(mappedBy = "etiquetas")
    private List<Noticia> noticias;
    @ManyToMany(mappedBy = "etiquetas")
    private List<DBPatent> patentes;

    public Etiqueta() {
        noticias = new ArrayList<Noticia>();
        patentes = new ArrayList<DBPatent>();
    }

    public Etiqueta(Long id, String valor, String color) {
        this.id = id;
        this.valor = valor;
        this.color = color;
        this.noticias = new LinkedList<Noticia>();
        this.patentes = new LinkedList<DBPatent>();
    }

    public Etiqueta(String valor, String color) {
        noticias = new ArrayList<Noticia>();
        patentes = new ArrayList<DBPatent>();
        this.valor = valor;
        this.color = color;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public mx.com.icvt.model.common.Etiqueta getEtiqueta() {
        return new mx.com.icvt.model.common.Etiqueta(this.id, this.valor, this.color);
    }
}
