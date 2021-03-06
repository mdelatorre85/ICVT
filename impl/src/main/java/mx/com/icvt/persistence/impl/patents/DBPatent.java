package mx.com.icvt.persistence.impl.patents;

import mx.com.icvt.model.Patent;
import mx.com.icvt.persistence.impl.tags.Etiqueta;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "Patentes")
public class DBPatent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text")
    private String titulo;

    @Column(columnDefinition = "text")
    private String descripcion;

    @Column(columnDefinition = "text")
    private String url;

    @Column(name = "fecha_publicacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPublicacion;

    @Column(columnDefinition = "text")
    private String contenido;

    @Column(columnDefinition = "text")
    private String autores;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "patente_tiene_etiquetas", joinColumns = {
            @JoinColumn(name = "id_patente")
    }, inverseJoinColumns = {
            @JoinColumn(name = "id_etiqueta")
    })
    private List<Etiqueta> etiquetas;

    @ManyToMany(mappedBy = "patentes")
    private List<ExtraccionPatentes> extracciones;

    public DBPatent() {
        this.extracciones = new LinkedList<ExtraccionPatentes>();
    }

    public DBPatent(Patent patent) {
        this.setTitulo(patent.getTittle());
        this.setDescripcion(patent.getDescriptionText());
        this.setUrl(patent.getUrl());
        this.setFechaPublicacion(patent.getPublicationDate());
        this.setContenido(patent.getPatentString());
        this.setAutores("");

        this.extracciones = new LinkedList<ExtraccionPatentes>();
    }

    public Patent getPatent() {
        Patent patent = new Patent();
        patent.setId(this.getId());
        patent.setTittle(this.getTitulo());
        patent.setDescriptionText(this.getDescripcion());
        patent.setUrl(this.getUrl());
        patent.setPublicationDate(this.getFechaPublicacion());
        patent.setPatentString(this.getContenido());
        patent.setAuthors(new ArrayList<String>());

        return patent;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public List<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public List<ExtraccionPatentes> getExtracciones() {
        return extracciones;
    }

    public void setExtracciones(List<ExtraccionPatentes> extracciones) {
        this.extracciones = extracciones;
    }
}
