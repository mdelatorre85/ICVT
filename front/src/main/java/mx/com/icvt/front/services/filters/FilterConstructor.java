package mx.com.icvt.front.services.filters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class FilterConstructor {
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public DateFilter getDateFilter(String fechaInicioParam, String fechaFinParam) {
        DateFilter filter = null;

        if (fechaInicioParam != null && fechaFinParam != null) {
            try {
                Date fechaInicio = FORMAT.parse(fechaInicioParam);
                Date fechaFin = FORMAT.parse(fechaFinParam);
                filter = new DateFilter(fechaInicio, fechaFin);
            } catch (ParseException e) {
                System.err.println("Las fechas proporcionadas no tiene el formato correcto");
            }
        }

        return filter;
    }

    public LabelFilter getLabelFilter(String etiquetasParam) {
        LabelFilter filter = null;

        if (etiquetasParam != null && !etiquetasParam.isEmpty()) {
            LinkedList<Long> ids = new LinkedList<Long>();

            String[] temp = etiquetasParam.split(",");
            for (String t : temp) {
                try {
                    ids.add(Long.parseLong(t));
                } catch (NumberFormatException e) {
                    System.err.printf("No se pudo parsear el valor %s\n", t);
                }
            }

            filter = new LabelFilter(ids);
        }

        return filter;
    }
}
