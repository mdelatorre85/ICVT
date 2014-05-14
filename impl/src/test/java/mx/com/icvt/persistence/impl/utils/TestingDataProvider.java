package mx.com.icvt.persistence.impl.utils;

import mx.com.icvt.persistence.impl.tags.Etiqueta;

import java.util.ArrayList;
import java.util.List;

public class TestingDataProvider {
    public List<Etiqueta> obtenerEtiquetasPrueba(){
        List<Etiqueta> etiquetas = new ArrayList<Etiqueta>();
        etiquetas.add(new Etiqueta("Economía", "blue"));
        etiquetas.add(new Etiqueta("Seguridad", "red"));
        etiquetas.add(new Etiqueta("Empleo", "orange"));
        etiquetas.add(new Etiqueta("Exportaciones", "green"));
        etiquetas.add(new Etiqueta("Eventos", "gray"));

        return etiquetas;
    }
}
