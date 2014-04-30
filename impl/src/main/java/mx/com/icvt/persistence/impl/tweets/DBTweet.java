package mx.com.icvt.persistence.impl.tweets;

import mx.com.icvt.model.Tweet;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Tweets")
public class DBTweet {
    @Id
    private Long id;
    private String texto;
    private Date fechaPublicacion;
    private String url;
    private Double latitud;
    private Double longitud;
    private Integer numeroRetweets;
    private Integer numeroFavoritos;

    private Long idUsuario;
    private String aliasUsuario;
    private String nombreUsuario;
    private String urlPerfilUsuario;

    public DBTweet() {
    }

    public DBTweet(Tweet tweet) {
        this.setTexto(tweet.getText());
        this.setUrl(tweet.getUrl());
        this.setFechaPublicacion(tweet.getPubDate());
        this.setUrl(tweet.getUrl());
        this.setLatitud(tweet.getLatitude());
        this.setLongitud(tweet.getLongitude());
        this.setNumeroRetweets(tweet.getRetweetCount());
        this.setNumeroFavoritos(tweet.getFavoriteCount());
        this.setId(tweet.getUserID());
        this.setAliasUsuario(tweet.getUserScreenName());
        this.setNombreUsuario(tweet.getUserName());
        this.setUrlPerfilUsuario(tweet.getUserProfileUrl());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Integer getNumeroRetweets() {
        return numeroRetweets;
    }

    public void setNumeroRetweets(Integer numeroRetweets) {
        this.numeroRetweets = numeroRetweets;
    }

    public Integer getNumeroFavoritos() {
        return numeroFavoritos;
    }

    public void setNumeroFavoritos(Integer numeroFavoritos) {
        this.numeroFavoritos = numeroFavoritos;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getAliasUsuario() {
        return aliasUsuario;
    }

    public void setAliasUsuario(String aliasUsuario) {
        this.aliasUsuario = aliasUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getUrlPerfilUsuario() {
        return urlPerfilUsuario;
    }

    public void setUrlPerfilUsuario(String urlPerfilUsuario) {
        this.urlPerfilUsuario = urlPerfilUsuario;
    }

    public Tweet getTweet() {
        Tweet tweet = new Tweet();
        tweet.setId(this.getId());
        tweet.setText(this.getTexto());
        tweet.setPubDate(this.getFechaPublicacion());
        tweet.setUrl(this.getUrl());
        tweet.setLatitude(this.getLatitud());
        tweet.setLongitude(this.getLongitud());
        tweet.setRetweetCount(this.getNumeroRetweets());
        tweet.setFavoriteCount(this.getNumeroFavoritos());
        tweet.setUserID(this.getIdUsuario());
        tweet.setUserScreenName(this.getAliasUsuario());
        tweet.setUserName(this.getNombreUsuario());
        tweet.setUserProfileUrl(this.getUrlPerfilUsuario());

        return tweet;
    }
}
