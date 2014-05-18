package mx.com.icvt.front.presenters.noticias;

import mx.com.icvt.front.presenters.commons.Etiqueta;

import java.util.LinkedList;
import java.util.List;

public class Noticia {
    private Long id;
    private String titulo;
    private String descripcion;
    private String imagen;
    private List<Etiqueta> etiquetas;
    private String fuente;
    private String url;

    public Noticia() {
        etiquetas = new LinkedList<Etiqueta>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public String getFuente() {
        return fuente;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
