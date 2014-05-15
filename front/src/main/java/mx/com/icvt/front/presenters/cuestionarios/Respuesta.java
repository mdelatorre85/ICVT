package mx.com.icvt.front.presenters.cuestionarios;

public class Respuesta {

    private Long id;
    private Long userId;
    private Long unidadEconomicaId;
    private String textoRespuesta;
    private String tipoDeRespuesta;

    public String getTipoDeRespuesta() {
        return tipoDeRespuesta;
    }

    public void setTipoDeRespuesta(TipoDeRespuesta tipoDeRespuesta) {
        this.tipoDeRespuesta = tipoDeRespuesta.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getTextoRespuesta() {
        return textoRespuesta;
    }

    public void setTextoRespuesta(String textoRespuesta) {
        this.textoRespuesta = textoRespuesta;
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

}
