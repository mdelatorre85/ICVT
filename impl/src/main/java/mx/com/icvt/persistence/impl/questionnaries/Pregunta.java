package mx.com.icvt.persistence.impl.questionnaries;

import mx.com.icvt.model.cuestionarios.MultipleOptionQuestion;
import mx.com.icvt.model.cuestionarios.OpenTextQuestion;
import mx.com.icvt.model.cuestionarios.Question;
import mx.com.icvt.model.cuestionarios.SingleOptionQuestion;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by miguelangeldelatorre on 13/05/14.
 */
@Entity
@Table(name = "Preguntas")
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo_de_pregunta")
    private String tipoDePregunta;

    @Column(name = "opciones_posibles", columnDefinition = "text")
    private String opcionesPosibles;

    @Column(name = "texto_pregunta", columnDefinition = "text")
    private String textoPregunta;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tema")
    private Tema tema;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "pregunta")
    private List<Respuesta> respuestas;

    private Pregunta(){
        respuestas = new ArrayList<Respuesta>();
    }

    public Pregunta(Question q) {
        this.id = q.getId();
        this.textoPregunta = q.getTextQuestion();
        respuestas = new ArrayList<Respuesta>();

        if (q instanceof OpenTextQuestion) {
            OpenTextQuestion otq = (OpenTextQuestion)q;
            tipoDePregunta = TipoDePregunta.PREGUNTAABIERTA.getName();
        } else if (q instanceof SingleOptionQuestion) {
            SingleOptionQuestion soq = (SingleOptionQuestion) q;
            StringBuilder sb = new StringBuilder();
            for (String option : soq.getPossibleOptions()) {
                sb.append(option);
                sb.append("|");
            }
            opcionesPosibles = sb.toString();
            opcionesPosibles = opcionesPosibles.substring(0, opcionesPosibles.length() - 1);
            tipoDePregunta = TipoDePregunta.OPCIONUNICA.getName();

        } else if (q instanceof MultipleOptionQuestion) {
            MultipleOptionQuestion moq = (MultipleOptionQuestion) q;
            StringBuilder sb = new StringBuilder();
            for (String option : moq.getPossibleOptions()) {
                sb.append(option);
                sb.append("|");
            }
            opcionesPosibles = sb.toString();
            opcionesPosibles = opcionesPosibles.substring(0, opcionesPosibles.length() - 1);
            tipoDePregunta = TipoDePregunta.OPCIONMULTIPLE.getName();
        }

    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public String getTipoDePregunta() {
        return tipoDePregunta;
    }

    public void setTipoDePregunta(TipoDePregunta tipoDePregunta) {
        this.tipoDePregunta = tipoDePregunta.getName();
    }

    public String getOpcionesPosibles() {
        return opcionesPosibles;
    }

    public void setOpcionesPosibles(String opcionesPosibles) {
        this.opcionesPosibles = opcionesPosibles;
    }

    public Question toQuestion() {

        if (tipoDePregunta.equals(TipoDePregunta.PREGUNTAABIERTA.getName())) {
            OpenTextQuestion otq = new OpenTextQuestion(textoPregunta);
            if (respuestas != null && respuestas.size() == 1) {
                otq.setAnswer(respuestas.get(0).toAnswer());
            }
            otq.setId(id);
            otq.setTopic(tema.toTopic());
            return otq;
        } else if (tipoDePregunta.equals(TipoDePregunta.OPCIONUNICA.getName())) {
            SingleOptionQuestion soq = new SingleOptionQuestion(textoPregunta);
            soq.setId(id);
            if (respuestas != null && respuestas.size() == 1) {
                soq.setAnswer(respuestas.get(0).toAnswer());
            }
            soq.setTopic(tema.toTopic());
            String[] posibles = opcionesPosibles.split("|");
            for (int i = 0; i < posibles.length; i++) {
                soq.getPossibleOptions().add(posibles[i]);
            }
            return soq;
        } else if (tipoDePregunta.equals(TipoDePregunta.OPCIONMULTIPLE.getName())) {
            MultipleOptionQuestion moq = new MultipleOptionQuestion(textoPregunta);
            moq.setId(id);
            if (respuestas != null && respuestas.size() == 1) {
                moq.setAnswer(respuestas.get(0).toAnswer());
            }
            moq.setTopic(tema.toTopic());
            String[] posibles = opcionesPosibles.split("|");
            for (int i = 0; i < posibles.length; i++) {
                moq.getPossibleOptions().add(posibles[i]);
            }
            return moq;
        }
        throw new InternalError("The Answer has a mistaken TipoDePregunta");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public enum TipoDePregunta {
        PREGUNTAABIERTA("preguntaAbierta"), OPCIONMULTIPLE("opcionMultiple"), OPCIONUNICA("opcionUnica"),;
        private String name;

        TipoDePregunta(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
