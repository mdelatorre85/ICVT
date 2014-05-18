package mx.com.icvt.front.presenters.cuestionarios;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by miguelangeldelatorre on 15/05/14.
 */
public class CuestionariosAgrupados {

    private List<Cuestionario> cuestionarios;
    private long unidadEconomicaId;

    public CuestionariosAgrupados(){
        cuestionarios= new ArrayList<Cuestionario>();
    }

    public List<Cuestionario> getCuestionarios() {
        return cuestionarios;
    }

    public void setCuestionarios(List<Cuestionario> cuestionarios) {
        this.cuestionarios = cuestionarios;
    }

    public long getUnidadEconomicaId() {
        return unidadEconomicaId;
    }

    public void setUnidadEconomicaId(long unidadEconomicaId) {
        this.unidadEconomicaId = unidadEconomicaId;
    }
}
