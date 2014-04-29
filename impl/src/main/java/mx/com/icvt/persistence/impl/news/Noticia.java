package mx.com.icvt.persistence.impl.news;

import mx.com.icvt.model.News;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import java.util.Date;

@PersistenceCapable
public class Noticia {
    @Persistent(primaryKey = "true", valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;
    private String url;
    private String titulo;
    private String descripcion;
    private Date fechaPublicacion;
    private String urlImagen;
    private String tituloMostrado;
    private String descripcionMostrada;
    private boolean habilitada;

    public Noticia() {
    }

    public Noticia(News news){
        this.url = news.getUrl();
        this.titulo = this.tituloMostrado = news.getTitle();
        this.descripcion = this.descripcionMostrada = news.getDescription();
        this.fechaPublicacion = news.getPubDate();
        this.urlImagen = news.getImage();
        this.habilitada = true;
    }

    public News getNews(){
        return new News(this.id, this.tituloMostrado, this.url, this.fechaPublicacion, this.descripcionMostrada, this.urlImagen);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getTituloMostrado() {
        return tituloMostrado;
    }

    public void setTituloMostrado(String tituloMostrado) {
        this.tituloMostrado = tituloMostrado;
    }

    public String getDescripcionMostrada() {
        return descripcionMostrada;
    }

    public void setDescripcionMostrada(String descripcionMostrada) {
        this.descripcionMostrada = descripcionMostrada;
    }

    public boolean isHabilitada() {
        return habilitada;
    }

    public void setHabilitada(boolean habilitada) {
        this.habilitada = habilitada;
    }
}