package mx.com.icvt.persistence.impl.tweets;

import mx.com.icvt.extraction.impl.twitter.TwitterExtractorConfiguration;
import mx.com.icvt.persistence.impl.vocaciones.ClaseActividad;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static mx.com.icvt.extraction.impl.twitter.TwitterExtractorConfiguration.TwitterSearchKind;
import static twitter4j.Query.ResultType;

@Entity
@Table(name = "configuracion_extraccion_tweets")
public class ConfiguracionExtraccionTweets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "termino_busqueda")
    private String terminoBusqueda;

    @Column(name = "numero_resultados")
    private int numeroResultados;

    @Column(name = "tipo_busqueda")
    private int tipoBusqueda;

    @Column(name = "tipo_resultado")
    private int tipoResultado;

    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;

    @ManyToOne
    @JoinColumn(name = "id_clase_actividad")
    private ClaseActividad claseActividad;

    @OneToMany(mappedBy = "configuracion")
    private List<ExtraccionTweets> extracciones;

    public ConfiguracionExtraccionTweets() {
        this.extracciones = new LinkedList<ExtraccionTweets>();
    }

    public ConfiguracionExtraccionTweets(String terminoBusqueda) {
        this.terminoBusqueda = terminoBusqueda;
        this.extracciones = new LinkedList<ExtraccionTweets>();
    }

    public TwitterExtractorConfiguration getConfiguration() {
        TwitterExtractorConfiguration configuration;
        TwitterSearchKind searchKind;
        ResultType resultType;

        switch (this.tipoBusqueda){
            case 0: searchKind = TwitterSearchKind.USERTIMELINE; break;
            default: searchKind = TwitterSearchKind.SEARCHQUERY; break;
        }

        switch (this.tipoResultado){
            case 0: resultType = ResultType.popular; break;
            case 1: resultType = ResultType.mixed; break;
            default: resultType = ResultType.recent; break;
        }

        configuration = new TwitterExtractorConfiguration(terminoBusqueda, searchKind);
        configuration.setId(this.id);
        configuration.setResultType(resultType);
        configuration.setCount(this.numeroResultados);
        configuration.setDateStart(this.fechaInicio);
        configuration.setDateEnd(this.fechaFin);

        return configuration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTerminoBusqueda() {
        return terminoBusqueda;
    }

    public void setTerminoBusqueda(String terminoBusqueda) {
        this.terminoBusqueda = terminoBusqueda;
    }

    public ClaseActividad getClaseActividad() {
        return claseActividad;
    }

    public void setClaseActividad(ClaseActividad claseActividad) {
        this.claseActividad = claseActividad;
    }

    public int getNumeroResultados() {
        return numeroResultados;
    }

    public void setNumeroResultados(int numeroResultados) {
        this.numeroResultados = numeroResultados;
    }

    public int getTipoBusqueda() {
        return tipoBusqueda;
    }

    public void setTipoBusqueda(int tipoBusqueda) {
        this.tipoBusqueda = tipoBusqueda;
    }

    public int getTipoResultado() {
        return tipoResultado;
    }

    public void setTipoResultado(int tipoResultado) {
        this.tipoResultado = tipoResultado;
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

    public List<ExtraccionTweets> getExtracciones() {
        return extracciones;
    }

    public void setExtracciones(List<ExtraccionTweets> extracciones) {
        this.extracciones = extracciones;
    }
}
