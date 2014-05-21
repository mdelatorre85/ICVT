package mx.com.icvt.persistence.impl.questionnaries;

import mx.com.icvt.model.EconomicUnit;
import mx.com.icvt.model.cuestionarios.Questionary;
import mx.com.icvt.model.cuestionarios.Topic;
import mx.com.icvt.persistence.impl.vocaciones.UnidadEconomica;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by miguelangeldelatorre on 13/05/14.
 */
@Entity
@Table(name = "cuestionarios")
public class Cuestionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", columnDefinition = "text")
    private String titulo;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cuestionario")
    private List<Tema> temas;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "unidad_economica_cuestionario", joinColumns = {
            @JoinColumn(name = "id_cuestionario")
    }, inverseJoinColumns = {
            @JoinColumn(name = "id_unidad_economica")
    })
    private List<UnidadEconomica> unidadEconomicas;


    public Cuestionario(Questionary questionary) {
        temas = new ArrayList<Tema>();
        unidadEconomicas = new ArrayList<UnidadEconomica>();
        this.id = questionary.getId();
        this.titulo = questionary.getTittle();
        for (Topic topic : questionary.getTopics()) {
            Tema tema = new Tema(topic);
            tema.setCuestionario(this);
            temas.add(tema);
        }

        for (EconomicUnit economicUnit : questionary.getEconomicUnits()) {
            UnidadEconomica unidadEconomica = new UnidadEconomica(economicUnit);
            unidadEconomica.getCuestionarios().add(this);
            unidadEconomicas.add(unidadEconomica);
        }
    }

    public Cuestionario() {
        temas = new ArrayList<Tema>();
        unidadEconomicas = new ArrayList<UnidadEconomica>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Tema> getTemas() {
        return temas;
    }

    public List<UnidadEconomica> getUnidadEconomicas() {
        return unidadEconomicas;
    }

    public void setUnidadEconomicas(List<UnidadEconomica> unidadEconomicas) {
        this.unidadEconomicas = unidadEconomicas;
    }

    public Questionary toQuestionary() {
        Questionary retorno = new Questionary();
        retorno.setId(id);
        retorno.setTittle(titulo);
        for (Tema t : temas) {
            Topic topic = t.toTopic();
            topic.setQuestionary(retorno);
            retorno.getTopics().add(topic);
        }
        return retorno;
    }
}
