package mx.com.icvt.persistence.impl.tweets;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "extraccion_tweets")
public class ExtraccionTweets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;

    @ManyToOne
    @JoinColumn(name = "id_configuracion")
    private ConfiguracionExtraccionTweets configuracion;

    @ManyToMany
    @JoinTable(name = "extraccion_tweets_tweets",
            joinColumns = {
                    @JoinColumn(name = "extraccion_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "tweet_id")
            }
    )
    private List<DBTweet> tweets;

    public ExtraccionTweets() {
    }

    public ExtraccionTweets(Date fechaInicio, Date fechaFin, ConfiguracionExtraccionTweets configuracion) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.configuracion = configuracion;
        this.tweets = new LinkedList<DBTweet>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public ConfiguracionExtraccionTweets getConfiguracion() {
        return configuracion;
    }

    public void setConfiguracion(ConfiguracionExtraccionTweets configuracion) {
        this.configuracion = configuracion;
    }

    public List<DBTweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<DBTweet> tweets) {
        this.tweets = tweets;
    }
}
