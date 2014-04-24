package mx.com.icvt.persistence.impl.patents;

import mx.com.icvt.model.Patent;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import java.util.ArrayList;
import java.util.Date;

@PersistenceCapable
public class DBPatent {
    @Persistent(primaryKey = "true", valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;
    private String titulo;
    private String descripcion;
    private String url;
    private Date fechaPublicacion;
    private String contenido;
    private String autores;

    public DBPatent() {
    }

    public DBPatent(Patent patent){
        this.setTitulo(patent.getTittle());
        this.setDescripcion(patent.getDescriptionText());
        this.setUrl(patent.getUrl());
        this.setFechaPublicacion(patent.getPublicationDate());
        this.setContenido(patent.getPatentString());
        this.setAutores("");
    }

    public Patent getPatent(){
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
}
