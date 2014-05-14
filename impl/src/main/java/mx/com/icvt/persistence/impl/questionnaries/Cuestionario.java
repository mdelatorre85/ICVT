package mx.com.icvt.persistence.impl.questionnaries;

import mx.com.icvt.model.cuestionarios.Questionary;
import mx.com.icvt.model.cuestionarios.Topic;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by miguelangeldelatorre on 13/05/14.
 */
@Entity
@Table(name = "Cuestionarios")
public class Cuestionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "cuestionario")
    private List<Tema> temas;

    public Cuestionario(Questionary questionary) {
        temas = new ArrayList<Tema>();
        this.id = questionary.getId();
        this.titulo = questionary.getTittle();
        for (Topic topic : questionary.getTopics()) {
            temas.add(new Tema(topic));
        }
    }

    public Cuestionario() {
        temas = new ArrayList<Tema>();
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
