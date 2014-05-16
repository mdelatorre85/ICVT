package mx.com.icvt.persistence.impl.tweets;

import mx.com.icvt.model.Tweet;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "tweets")
@NamedQueries({
        @NamedQuery(
                name = "getTweetsByDate",
                query = "SELECT t FROM DBTweet t " +
                        "WHERE t.fechaPublicacion >= :inicio " +
                        "AND t.fechaPublicacion <= :fin " +
                        "ORDER BY t.fechaPublicacion DESC"),
        @NamedQuery(
                name = "getRecentTweets",
                query = "SELECT t FROM DBTweet t " +
                        "ORDER BY t.fechaPublicacion DESC"
        )
})

public class DBTweet {
    @Id
    private Long id;

    private String texto;

    @Column(name = "fecha_publicacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPublicacion;

    @Column(columnDefinition = "text")
    private String url;

    private Double latitud;

    private Double longitud;

    @Column(name = "numero_retweets")
    private Integer numeroRetweets;

    @Column(name = "numero_favoritos")
    private Integer numeroFavoritos;

    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "alias_usuario")
    private String aliasUsuario;

    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    @Column(name = "url_perfil_usuario", columnDefinition = "text")
    private String urlPerfilUsuario;

    @ManyToMany(mappedBy = "tweets")
    private List<ExtraccionTweets> extracciones;

    public DBTweet() {
        this.extracciones = new LinkedList<ExtraccionTweets>();
    }

    public DBTweet(Tweet tweet) {
        this.id = tweet.getId();
        this.texto = tweet.getText();
        this.url = tweet.getUrl();
        this.fechaPublicacion = tweet.getPubDate();
        this.latitud = tweet.getLatitude();
        this.longitud = tweet.getLongitude();
        this.numeroRetweets = tweet.getRetweetCount();
        this.numeroFavoritos = tweet.getFavoriteCount();
        this.idUsuario = tweet.getUserID();
        this.aliasUsuario = tweet.getUserScreenName();
        this.nombreUsuario = tweet.getUserName();
        this.urlPerfilUsuario = tweet.getUserProfileUrl();

        this.extracciones = new LinkedList<ExtraccionTweets>();
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
