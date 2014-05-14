package mx.com.icvt.persistence.impl.questionnaries;

import mx.com.icvt.model.cuestionarios.Question;
import mx.com.icvt.model.cuestionarios.Questionary;
import mx.com.icvt.model.cuestionarios.Topic;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by miguelangeldelatorre on 13/05/14.
 */
@Entity
@Table(name = "Temas")
public class Tema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "tema")
    private List<Pregunta> preguntas;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cuestionario")
    private Cuestionario cuestionario;


    public Tema(Topic topic) {
        this.id = topic.getId();
        preguntas = new ArrayList<Pregunta>();
        for (Question q : topic.getQuestions()) {
            preguntas.add(new Pregunta(q));
        }
    }

    public Tema() {
        preguntas = new ArrayList<Pregunta>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public Cuestionario getCuestionario() {
        return cuestionario;
    }

    public void setCuestionario(Cuestionario cuestionario) {
        this.cuestionario = cuestionario;
    }

    public Topic toTopic() {
        Topic retorno = new Topic(new Questionary());
        retorno.setId(id);
        for (Pregunta p : preguntas) {
            retorno.getQuestions().add(p.toQuestion());
        }
        return retorno;
    }
}
