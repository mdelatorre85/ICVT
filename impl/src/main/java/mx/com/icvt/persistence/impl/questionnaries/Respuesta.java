package mx.com.icvt.persistence.impl.questionnaries;

import mx.com.icvt.model.cuestionarios.*;

import javax.persistence.*;

/**
 * Created by miguelangeldelatorre on 13/05/14.
 */
@Entity
@Table(name = "Respuestas")
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_pregunta")
    private Pregunta pregunta;

    @Column(name = "id_usuario")
    private Long userId;

    @Column(name = "id_unidad_economica")
    private Long unidadEconomicaId;

    @Column(name = "texto_respuesta", columnDefinition = "text")
    private String textoRespuesta;

    @Column(name = "tipo_de_respuesta")
    private String tipoDeRespuesta;

    public Respuesta(Answer answer) {
        id = answer.getId();
        userId = answer.getUserId();
        unidadEconomicaId = answer.getEconomicUnitId();
        pregunta = new Pregunta(answer.getQuestion());

        if (answer instanceof OpenTextAnswer) {
            OpenTextAnswer ota = (OpenTextAnswer) answer;
            textoRespuesta = ota.getAnswer();
            tipoDeRespuesta = TipoDeRespuesta.RESPUESTAAPREGUNTAABIERTA.getName();
        } else if (answer instanceof SingleOptionAnswer) {
            SingleOptionAnswer soa = (SingleOptionAnswer) answer;
            textoRespuesta = soa.getAnswer().toString();
            tipoDeRespuesta = TipoDeRespuesta.RESPUESTAAOPCIONUNICA.getName();
        }else if (answer instanceof MultipleOptionAnswer) {
            MultipleOptionAnswer moa = (MultipleOptionAnswer) answer;
            StringBuilder sb= new StringBuilder();
            tipoDeRespuesta = TipoDeRespuesta.RESPUESTAAOPCIONMULTIPLE.getName();
            for (Integer aanswer: moa.getAnswers()){
                sb.append(aanswer);
                sb.append("|");
            }
            textoRespuesta = sb.toString();
            textoRespuesta = textoRespuesta.substring(0, textoRespuesta.length() - 1);
        }

    }

    public void setTipoDeRespuesta(TipoDeRespuesta tipoDeRespuesta) {
        this.tipoDeRespuesta = tipoDeRespuesta.getName();
    }

    public String getTipoDeRespuesta() {
        return tipoDeRespuesta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUnidadEconomicaId() {
        return unidadEconomicaId;
    }

    public void setUnidadEconomicaId(Long unidadEconomicaId) {
        this.unidadEconomicaId = unidadEconomicaId;
    }

    public enum TipoDeRespuesta {
        RESPUESTAAPREGUNTAABIERTA("preguntaAbierta"), RESPUESTAAOPCIONMULTIPLE("opcionMultiple"), RESPUESTAAOPCIONUNICA("opcionUnica"),;
        private String name;

        TipoDeRespuesta(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public Answer toAnswer(){

        if (tipoDeRespuesta.equals(TipoDeRespuesta.RESPUESTAAPREGUNTAABIERTA.getName())){
            OpenTextAnswer ota = new OpenTextAnswer(userId, (OpenTextQuestion)pregunta.toQuestion(),textoRespuesta);
            ota.setEconomicUnitId(unidadEconomicaId);
            ota.setId(id);
            ota.setQuestionId(pregunta.getId());
            ota.setAnswer(textoRespuesta);
            return ota;
        }else if (tipoDeRespuesta.equals(TipoDeRespuesta.RESPUESTAAOPCIONUNICA.getName())){
            SingleOptionAnswer soa = new SingleOptionAnswer(userId,(SingleOptionQuestion)pregunta.toQuestion());
            soa.setAnswer(Integer.parseInt(textoRespuesta));
            soa.setId(id);
            soa.setEconomicUnitId(unidadEconomicaId);
            soa.setQuestionId(pregunta.getId());
            return soa;
        } else if (tipoDeRespuesta.equals(TipoDeRespuesta.RESPUESTAAOPCIONMULTIPLE.getName())){
            MultipleOptionAnswer moa = new MultipleOptionAnswer(userId,(MultipleOptionQuestion)pregunta.toQuestion());
            moa.setQuestionId(pregunta.getId());
            moa.setEconomicUnitId(unidadEconomicaId);
            moa.setQuestionId(pregunta.getId());
            String[] respuestas = textoRespuesta.split("|");
            for(int i = 0; i<respuestas.length;i++){
                moa.getAnswers().add(Integer.parseInt(respuestas[i]));
            }
            return moa;
        }

        throw new InternalError("The Answer has a mistaken TipoDeRespuesta");
    }
}
