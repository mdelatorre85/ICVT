package mx.com.icvt.front.services.filters;

import java.util.Date;

public class DateFilter {
    private Date fechaInicio;
    private Date fechaFin;

    public DateFilter(Date fechaInicio, Date fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Date getFechaInicio() {
        return new Date(fechaInicio.getTime());
    }

    public Date getFechaFin() {
        return new Date(fechaFin.getTime());
    }
}
