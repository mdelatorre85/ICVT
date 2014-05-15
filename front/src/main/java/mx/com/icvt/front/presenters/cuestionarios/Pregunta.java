package mx.com.icvt.front.presenters.cuestionarios;

public class Pregunta {

    private Long id;
    private String tipoDePregunta;
    private String opcionesPosibles;
    private String textoPregunta;

    private Respuesta respuesta;

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
