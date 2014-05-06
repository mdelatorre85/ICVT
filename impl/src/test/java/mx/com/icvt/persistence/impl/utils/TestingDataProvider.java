package mx.com.icvt.persistence.impl.utils;

import mx.com.icvt.persistence.impl.tags.Etiqueta;

import java.util.ArrayList;
import java.util.List;

public class TestingDataProvider {
    public List<Etiqueta> obtenerEtiquetasPrueba(){
        List<Etiqueta> etiquetas = new ArrayList<Etiqueta>();
        etiquetas.add(new Etiqueta("Economía"));
        etiquetas.add(new Etiqueta("Seguridad"));
        etiquetas.add(new Etiqueta("Empleo"));
        etiquetas.add(new Etiqueta("Exportaciones"));
        etiquetas.add(new Etiqueta("Eventos"));

        return etiquetas;
    }
}
