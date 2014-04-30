package mx.com.icvt.persistence.impl.utils;

import mx.com.icvt.persistence.impl.tags.Etiqueta;

import java.util.ArrayList;
import java.util.List;

public class TestingDataProvider {
    public static final List<Etiqueta> ETIQUETAS;
    static {
        ETIQUETAS = new ArrayList<Etiqueta>();
        ETIQUETAS.add(new Etiqueta("ECONOMÍA"));
        ETIQUETAS.add(new Etiqueta("SEGURIDAD"));
        ETIQUETAS.add(new Etiqueta("EMPLEO"));
        ETIQUETAS.add(new Etiqueta("EXPORTACIONES"));
        ETIQUETAS.add(new Etiqueta("EVENTOS"));
    }
}
