package mx.com.icvt.front.presenters.cuestionarios;

import java.util.ArrayList;
import java.util.List;

public class Pregunta {

    private Long id;
    private String tipoDePregunta;
    private List<String> opcionesPosibles;
    private String textoPregunta;
    private Respuesta respuesta;

    public Pregunta(){
        opcionesPosibles = new ArrayList<String>();
    }

    public Pregunta(Long id, TipoDePregunta tipoDePregunta, String textoPregunta){
        opcionesPosibles = new ArrayList<String>();
        this.id = id;
        this.tipoDePregunta = tipoDePregunta.getName();
        this.textoPregunta = textoPregunta;
    }

    public String getTipoDePregunta() {
        return tipoDePregunta;
    }

    public void setTipoDePregunta(TipoDePregunta tipoDePregunta) {
        this.tipoDePregunta = tipoDePregunta.getName();
    }

    public List<String> getOpcionesPosibles() {
        return opcionesPosibles;
    }

    public void setOpcionesPosibles(List<String> opcionesPosibles) {
        this.opcionesPosibles = opcionesPosibles;
    }

    public String getTextoPregunta() {
        return textoPregunta;
    }

    public void setTextoPregunta(String textoPregunta) {
        this.textoPregunta = textoPregunta;
    }

    public Respuesta getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Respuesta respuesta) {
        this.respuesta = respuesta;
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
