package mx.com.icvt.persistence.impl.news;

import mx.com.icvt.model.News;
import mx.com.icvt.persistence.impl.tags.Etiqueta;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Noticias")
public class Noticia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text")
    private String url;

    @Column(columnDefinition = "text")
    private String titulo;

    @Column(columnDefinition = "text")
    private String descripcion;

    @Column(name = "fecha_publicacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPublicacion;

    @Column(name = "url_imagen", columnDefinition = "text")
    private String urlImagen;

    @Column(name = "titulo_mostrado", columnDefinition = "text")
    private String tituloMostrado;

    @Column(name = "descripcion_mostrada", columnDefinition = "text")
    private String descripcionMostrada;

    private boolean habilitada;

    @Column(columnDefinition = "text")
    private String fuente;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "noticia_tiene_etiquetas", joinColumns = {
            @JoinColumn(name = "id_noticia")
    }, inverseJoinColumns = {
            @JoinColumn(name = "id_etiqueta")
    })
    private List<Etiqueta> etiquetas;

    @ManyToMany(mappedBy = "noticias")
    private List<ExtraccionNoticias> extracciones;

    public Noticia() {
        etiquetas = new ArrayList<Etiqueta>();
    }

    public Noticia(News news) {
        etiquetas = new ArrayList<Etiqueta>();
        this.url = news.getUrl();
        this.titulo = this.tituloMostrado = news.getTitle();
        this.descripcion = this.descripcionMostrada = news.getDescription();
        this.fuente = news.getSource();
        this.urlImagen = news.getImage();
        this.fechaPublicacion = news.getPubDate();
        this.habilitada = true;
    }

    public News getNews() {
        News news = new News(this.id, this.tituloMostrado, this.url, this.fechaPublicacion, this.descripcionMostrada, this.urlImagen, this.fuente);

        for (Etiqueta e : etiquetas) {
            news.addEtiqueta(e.getId(), e.getValor());
        }

        return news;
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

    public List<ExtraccionNoticias> getExtracciones() {
        return extracciones;
    }

    public void setExtracciones(List<ExtraccionNoticias> extracciones) {
        this.extracciones = extracciones;
    }

    public String getFuente() {
        return fuente;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
    }
}