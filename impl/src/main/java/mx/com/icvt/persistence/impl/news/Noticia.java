package mx.com.icvt.persistence.impl.news;

import mx.com.icvt.model.News;
import mx.com.icvt.persistence.impl.tags.Etiqueta;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Noticias")
public class Noticia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    private String titulo;
    private String descripcion;
    private Date fechaPublicacion;
    private String urlImagen;
    private String tituloMostrado;
    private String descripcionMostrada;
    private boolean habilitada;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "NoticiaEtiqueta", joinColumns = {
            @JoinColumn(name = "idNoticia")
    }, inverseJoinColumns = {
            @JoinColumn(name = "idEtiqueta")
    })
    private List<Etiqueta> etiquetas;

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

    public List<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }
}