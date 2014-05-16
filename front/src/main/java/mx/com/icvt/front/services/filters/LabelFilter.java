package mx.com.icvt.front.services.filters;

import java.util.Collections;
import java.util.List;

public class LabelFilter {
    private List<Long> etiquetas;

    public LabelFilter(List<Long> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public List<Long> getEtiquetas() {
        return Collections.unmodifiableList(etiquetas);
    }
}
